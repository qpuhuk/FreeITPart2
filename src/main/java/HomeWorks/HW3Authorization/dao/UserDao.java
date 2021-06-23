package HomeWorks.HW3Authorization.dao;

import HomeWorks.HW3Authorization.entity.User;

import java.sql.SQLException;

public interface UserDao {
    User getByName(String username) throws SQLException;

    boolean create(User user) throws SQLException;
}
