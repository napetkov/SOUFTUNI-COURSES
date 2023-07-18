package bg.softuni.jsonxsmlexercise.constant;

import java.nio.file.Path;

public enum Paths {
    ;

//    JSON Import Path
    public static Path CATEGORIES_JSON_PATH =
            Path.of("src","main","resources","dbContent", "json", "categories.json");

    public static Path USERS_JSON_PATH =
            Path.of("src","main","resources","dbContent", "json", "users.json");

    public static Path PRODUCTS_JSON_PATH =
            Path.of("src","main","resources","dbContent", "json", "products.json");


    //    XML Import Path
public static Path CATEGORIES_XML_PATH =
        Path.of("src","main","resources","dbContent", "xml", "categories.xml");

    public static Path USERS_XML_PATH =
            Path.of("src","main","resources","dbContent", "xml", "users.xml");

    public static Path PRODUCTS_XML_PATH =
            Path.of("src","main","resources","dbContent", "xml", "products.xml");



// JSON OUTPUT PATH
    public static Path FIRST_JSON_PATH =
            Path.of("src","main","resources","output", "json", "1.json");

    public static Path SECOND_JSON_PATH =
            Path.of("src","main","resources","output", "json", "2.json");

    public static Path THIRD_JSON_PATH =
            Path.of("src","main","resources","output", "json", "3.json");

    public static Path FOURTH_JSON_PATH =
            Path.of("src","main","resources","output", "json", "4.json");

//    XML OUTPUT PATH

    public static Path FIRST_XML_PATH =
            Path.of("src","main","resources","output", "xml", "1.xml");

    public static Path SECOND_XML_PATH =
            Path.of("src","main","resources","output", "xml", "2.xml");

    public static Path THIRD_XML_PATH =
            Path.of("src","main","resources","output", "xml", "3.xml");

    public static Path FOURTH_XML_PATH =
            Path.of("src","main","resources","output", "xml", "4.xml");
}
