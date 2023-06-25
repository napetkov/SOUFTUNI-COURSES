package orm;

import orm.anotations.Column;
import orm.anotations.Entity;
import orm.anotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EntityManager<E> implements DBContext<E> {
    private static final String INSERT_INTO = "SELECT INTO %s (%s) VALUES (%s); ";
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field idField = getIdField(entity.getClass());
        idField.setAccessible(true);
        Object idValue = idField.get(entity);

        if (idValue == null || (int) idValue == 0) {
            return insertEntity(entity);
        }
        return false;
//        return updateEntity();
    }

    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, null);
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String SELECT_QUERY_SINGLE = "SELECT * FROM %s %s LIMIT 1";
        String tableName = getTableName(table);
        String actualWhere = where == null ? "" : where;

        String query = String.format(SELECT_QUERY_SINGLE, tableName, actualWhere);

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return creteEntity(table, resultSet);
        }

        return null;
    }

    private E creteEntity(Class<E> table, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        E entity = table.getDeclaredConstructor().newInstance();

        Arrays.stream(table.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .forEach(f -> {
                    try {
                        fillFieldData(entity, f, resultSet);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        return entity;
    }

    private void fillFieldData(E entity, Field field, ResultSet resultSet) throws SQLException, IllegalAccessException {
        field.setAccessible(true);

        String fieldName = field.getAnnotation(Column.class).name();

        Class<?> fieldType = field.getType();

        Object value;
        if (fieldType == int.class ) {
            value = resultSet.getInt(fieldName);
        } else if (fieldType == LocalDate.class) {
            String stringDate = resultSet.getString(fieldName);
            value = LocalDate.parse(stringDate);
        } else {
            value = resultSet.getString(fieldName);
        }

        field.set(entity, value);
    }

    private Field getIdField(Class<?> entityClass) {
        Field[] declaredFields = entityClass
                .getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Id.class)) {
                return declaredField;
            }
        }
        throw new UnsupportedOperationException("Entity does not have ID column");
    }

    private boolean insertEntity(E entity) throws SQLException {

        String tableName = getTableName(entity.getClass());
        String fieldsNameWithoutId = getFieldsNameWithoutId(entity.getClass());
        String fieldsValuesWithoutId = getFieldsValuesWithoutId(entity);


        String query = String.format(INSERT_INTO, tableName, fieldsNameWithoutId, fieldsValuesWithoutId);

        PreparedStatement statement = this.connection.prepareStatement(query);

        return statement.executeUpdate() == 1;
    }

    private String getTableName(Class<?> entityClass) {
        Entity annotation = entityClass.getAnnotation(Entity.class);

        if (annotation == null) {
            throw new UnsupportedOperationException("Entity must have Entity annotation");
        }
        return annotation.name();
    }

    private String getFieldsNameWithoutId(Class<?> entityClass) {
        Field idField = getIdField(entityClass);

        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> !f.getName().equals(idField.getName()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> f.getAnnotation(Column.class).name())
                .collect(Collectors.joining(", "));


    }

    private String getFieldsValuesWithoutId(E entity) {
        Class<?> entityClass = entity.getClass();

        Field idField = getIdField(entityClass);

        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(f -> !f.getName().equals(idField.getName()))
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> {
                    f.setAccessible(true);
                    try {
                        Object value = f.get(entity);
                        return String.format("'%s'", value.toString());

                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(", "));


    }
}
