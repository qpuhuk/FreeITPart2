package HomeWorks.HW5.hibernate.dao;

import HomeWorks.HW5.hibernate.dao.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

}
