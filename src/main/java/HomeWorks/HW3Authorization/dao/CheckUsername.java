package HomeWorks.HW3Authorization.dao;

import HomeWorks.HW3Authorization.connection.ConnectionDBMySql;
import HomeWorks.HW3Authorization.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckUsername implements UserCheckDao {
    @Override
    public boolean checkLogin(String username) {
        String usernameCheck = null;
        try {
            Connection connection = ConnectionDBMySql.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.CHECK_THE_USERNAME);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                usernameCheck = result.getString(1);
            }
            ConnectionDBMySql.closeConnection();
            return usernameCheck != null && !usernameCheck.isEmpty();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkPass(String pass) {
        String password = null;
        try {
            Connection connection = ConnectionDBMySql.getConnection();
            PreparedStatement statement = connection.prepareStatement(Queries.CHECK_A_PASS_OF_USER);
            statement.setString(1, pass);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                password = resultSet.getString(1);
            }
            ConnectionDBMySql.closeConnection();
            return password != null && !password.isEmpty();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addUser(User user) {
        PreparedStatement statement = null;
        try {
            Connection connection = ConnectionDBMySql.getConnection();
            statement = connection.prepareStatement(Queries.ADD_NEW_USER);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            return statement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (statement == null) throw new AssertionError();
            statement.close();
            ConnectionDBMySql.closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
