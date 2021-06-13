package HomeWorks.HW3Authorization.service;

import HomeWorks.HW3Authorization.entity.User;

public class UserService {

    public User createUser(String login, String pass, String name) {

        User user = new User();
        user.setUsername(login);
        user.setPassword(pass);
        user.setName(name);
        return user;
    }
}
