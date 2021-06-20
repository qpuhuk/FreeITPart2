package HomeWorks.HW4.service;

import HomeWorks.HW4.controller.dto.PersonDto;
import HomeWorks.HW4.dao.PersonDao;
import HomeWorks.HW4.dao.entities.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonDao dao;

    @Autowired
    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(personDto.getFirstName());
        personEntity.setLastName(personDto.getLastName());
        dao.save(personEntity);
        return personDto;
    }
}
