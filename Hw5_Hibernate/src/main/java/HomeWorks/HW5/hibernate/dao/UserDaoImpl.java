package HomeWorks.HW5.hibernate.dao;

import HomeWorks.HW5.hibernate.dao.entities.UserEntity;
import HomeWorks.HW5.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public UserEntity findById(Integer id) {
        UserEntity userEntity = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            userEntity = session.get(UserEntity.class, id);
            transaction.commit();
        } catch (HibernateException exception) {
            assert transaction != null;
            transaction.rollback();
            throw new HibernateException(exception);
        }
        return userEntity;
    }
}
