package HomeWorks.HW4.dao;

import HomeWorks.HW4.dao.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<PersonEntity, Integer> {
    PersonEntity findByFirstName(String firstname);


}
