package HomeWorks.HW3Authorization.connection;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDBMySql {
    private static final String URL = "jdbc:mysql://localhost:3306/checkLogin";
    private static final String USER = "root";
    private static final String PASSWORD = "Boybot007!";
    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
