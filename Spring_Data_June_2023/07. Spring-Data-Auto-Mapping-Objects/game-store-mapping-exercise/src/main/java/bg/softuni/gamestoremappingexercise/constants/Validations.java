package bg.softuni.gamestoremappingexercise.constants;

public enum Validations {
    ;
    public static final String EMAIL_PATTERN = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z]{2,5}){1,2}$";
    public static final String ADD_GAME_TITLE_PATTERN = "^[A-Z](.*){3,100}$";
    public static final String ADD_GAME_TRAILER_PATTERN = "^.{11}$";
    public static final String ADD_GAME_THUMBNAIL_URL_PATTERN = "^(http|https)://.*";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{6,}$";
}
