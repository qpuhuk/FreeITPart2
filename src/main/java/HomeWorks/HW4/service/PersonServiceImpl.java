package HomeWorks.HW4.service;

import HomeWorks.HW4.controller.dto.PersonDto;
import HomeWorks.HW4.dao.PersonDao;
import HomeWorks.HW4.dao.entities.PersonEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonDao dao;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(personDto.getFirstName());
        personEntity.setLastName(personDto.getLastName());
        dao.save(personEntity);
        return personDto;
    }
}
