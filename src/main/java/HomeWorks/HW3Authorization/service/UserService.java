package HomeWorks.HW3Authorization.service;

import HomeWorks.HW3Authorization.dao.entity.User;

import java.sql.SQLException;

public interface UserService {

    User getByName(String username) throws SQLException;

    boolean create(String username, String pass, String name) throws SQLException;
}
