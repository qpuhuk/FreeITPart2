package HomeWorks.HW4.example2.dao;

import HomeWorks.HW4.example2.dao.entities.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalDao extends JpaRepository<AnimalEntity, Integer> {
    AnimalEntity findByAge(int age);
}
