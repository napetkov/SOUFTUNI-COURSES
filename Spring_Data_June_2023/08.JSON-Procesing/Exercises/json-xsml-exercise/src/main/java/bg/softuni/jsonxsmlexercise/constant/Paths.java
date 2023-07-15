package bg.softuni.jsonxsmlexercise.constant;

import java.nio.file.Path;

public enum Paths {
    ;
    public static Path CATEGORIES_JSON_PATH =
            Path.of("src","main","resources","dbContent", "categories.json");

    public static Path USERS_JSON_PATH =
            Path.of("src","main","resources","dbContent", "users.json");

    public static Path PRODUCTS_JSON_PATH =
            Path.of("src","main","resources","dbContent", "products.json");

    public static Path FIRST_JSON_PATH =
            Path.of("src","main","resources","output", "1.json");

    public static Path SECOND_JSON_PATH =
            Path.of("src","main","resources","output", "2.json");

    public static Path THIRD_JSON_PATH =
            Path.of("src","main","resources","output", "3.json");

    public static Path FOURTH_JSON_PATH =
            Path.of("src","main","resources","output", "4.json");
}
