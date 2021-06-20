package HomeWorks.HW3Authorization.service;

import HomeWorks.HW3Authorization.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserService {

    User createUserFromBD(String username) throws SQLException;

    boolean addUserInDB(String username, String pass, String name);

}
