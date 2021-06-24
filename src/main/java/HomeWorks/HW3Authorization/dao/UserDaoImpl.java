package HomeWorks.HW3Authorization.dao;

import HomeWorks.HW3Authorization.connection.ConnectionDBMySql;
import HomeWorks.HW3Authorization.dao.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User getByName(String username) throws SQLException {
        try (Connection connection = ConnectionDBMySql.getConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.CHECK_THE_USERNAME)) {
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                User user = new User();
                user.setUsername(result.getString("login"));
                user.setId(result.getInt("id"));
                user.setPassword(result.getString("password"));
                user.setName(result.getString("name"));
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean create(User user) throws SQLException {
        try (Connection connection = ConnectionDBMySql.getConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.ADD_NEW_USER)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            return statement.executeUpdate() == 1;
        }
    }
}
