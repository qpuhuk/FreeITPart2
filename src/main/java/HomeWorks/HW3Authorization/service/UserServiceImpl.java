package HomeWorks.HW3Authorization.service;

import HomeWorks.HW3Authorization.dao.UserDao;
import HomeWorks.HW3Authorization.dao.UserDaoImpl;
import HomeWorks.HW3Authorization.entity.User;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User createUserFromBD(String username) {
        return userDao.createUser(username);
    }

    @Override
    public boolean addUserInDB(String username, String pass, String name) {
        User userService = new User();
        userService.setUsername(username);
        userService.setPassword(pass);
        userService.setName(name);
        return userDao.addUser(userService);
    }
}

