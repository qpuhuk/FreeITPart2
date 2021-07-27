package HomeWorks.HW5.hibernate.dao;

import HomeWorks.HW5.hibernate.dao.entities.AddressEntity;
import HomeWorks.HW5.hibernate.dao.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findById(int id);

    List<UserEntity> findUserEntityByAddress(AddressEntity addressEntity);
}
