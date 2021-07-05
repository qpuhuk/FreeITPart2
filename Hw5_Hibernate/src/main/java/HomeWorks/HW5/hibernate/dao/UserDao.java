package HomeWorks.HW5.hibernate.dao;

import HomeWorks.HW5.hibernate.dao.entities.UserEntity;

public interface UserDao {
    UserEntity findById(Integer id);
}
