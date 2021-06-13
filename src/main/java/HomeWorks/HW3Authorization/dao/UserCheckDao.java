package HomeWorks.HW3Authorization.dao;

import HomeWorks.HW3Authorization.entity.User;

public interface UserCheckDao {
    boolean checkLogin(String username);

    boolean checkPass(String pass);

    boolean addUser(User user);

}
