package HomeWorks.HW3Authorization.dao;

public class Queries {
    public static final String CHECK_THE_USERNAME = "SELECT login FROM users WHERE login = ?";
    public static final String CHECK_A_PASS_OF_USER = "SELECT password FROM users WHERE login = ?";
    public static final String ADD_NEW_USER = "INSERT INTO users (login, password, name) values (?, ?, ?)";
    public static final String SELECT_THE_NAME_OF_THE_USER = "SELECT name FROM users WHERE login = ?";
}
