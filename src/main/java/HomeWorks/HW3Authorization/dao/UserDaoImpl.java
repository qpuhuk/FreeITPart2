package HomeWorks.HW3Authorization.dao;

import HomeWorks.HW3Authorization.entity.User;

public class UserDaoImpl implements UserDao {
    UserDao checkInDB = new UserCheck();

    @Override
    public boolean checkLogin(String username) {
        return checkInDB.checkLogin(username);
    }

    @Override
    public boolean checkPass(String pass) {
        return checkInDB.checkPass(pass);
    }

    @Override
    public boolean addUser(User user) {
        return checkInDB.addUser(user);
    }

    @Override
    public String getNameOfUser(String username) {
        return checkInDB.getNameOfUser(username);
    }
}
