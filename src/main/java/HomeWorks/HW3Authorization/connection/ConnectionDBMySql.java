package HomeWorks.HW3Authorization.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDBMySql {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/checkLogin";
        String user = "root";
        String password = "Boybot007!";
        return DriverManager.getConnection(url, user, password);
    }
}
