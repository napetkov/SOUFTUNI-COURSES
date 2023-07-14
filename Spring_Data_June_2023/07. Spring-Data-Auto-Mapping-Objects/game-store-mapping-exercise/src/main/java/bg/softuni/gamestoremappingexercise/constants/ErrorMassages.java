package bg.softuni.gamestoremappingexercise.constants;

public enum ErrorMassages {
    ;
    public static final String PASS_MISS_MATCH = "Password miss match!";
    public static final String INVALID_PASSWORD = "Invalid Password.";
    public static final String INVALID_EMAIL = "Email doesn't match our requirements";
    public static final String EMAIL_ALREADY_EXIST = "Email already exist";
    public static final String GAME_TITTLE_IS_NOT_IN_REQUIREMENTS =
            "Please insert title starting with uppercase letter and length between 3 and 100 symbols.";
    public static final String GAME_TRAILER_IS_NOT_IN_REQUIREMENTS = "No such ID for youtube.com";
    public static final String PRICE_MUST_BE_POSITIVE_NUMBER = "Please insert positive number for price.";
    public static final String DESCRIPTION_LENGTH_MUST_BE_AT_LAST_20_SYMBOLS = "Description length must be at last 20 symbols.";
    public static final String GAME_THUMBNAIL_URL_PATTERN_IS_NOT_IN_REQUIREMENTS =
            "Please insert thumbnail start with http:// or https://.";
    public static final String SIZE_MUST_BE_POSITIVE_NUMBER = "Please insert positive number for size.";

}
