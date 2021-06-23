package HomeWorks.HW3Authorization.service;

import HomeWorks.HW3Authorization.dao.UserDao;
import HomeWorks.HW3Authorization.dao.UserDaoImpl;
import HomeWorks.HW3Authorization.entity.User;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User getByName(String username) throws SQLException {
        return userDao.getByName(username);
    }

    @Override
    public boolean create(String username, String pass, String name) throws SQLException {
        User userService = new User();
        userService.setUsername(username);
        userService.setPassword(pass);
        userService.setName(name);
        return userDao.create(userService);
    }
}

