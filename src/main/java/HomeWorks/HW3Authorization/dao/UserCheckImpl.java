package HomeWorks.HW3Authorization.dao;

import HomeWorks.HW3Authorization.entity.User;

public class UserCheckImpl implements UserCheckDao {
    UserCheckDao checkInDB = new CheckUsername();

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
}
