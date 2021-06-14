package HomeWorks.HW3Authorization.dao;

import HomeWorks.HW3Authorization.entity.User;

public interface UserDao {
    boolean checkLogin(String username);

    boolean checkPass(String pass);

    boolean addUser(User user);

    String getNameOfUser(String username);

}
