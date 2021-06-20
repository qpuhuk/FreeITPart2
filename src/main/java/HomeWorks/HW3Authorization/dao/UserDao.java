package HomeWorks.HW3Authorization.dao;

import HomeWorks.HW3Authorization.entity.User;

public interface UserDao {
    User createUser(String username);

    boolean addUser(User user);
}
