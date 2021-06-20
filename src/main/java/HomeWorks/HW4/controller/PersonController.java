package HomeWorks.HW4.controller;

import HomeWorks.HW4.controller.dto.PersonDto;
import HomeWorks.HW4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/people")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        return new ResponseEntity<>(personService.createPerson(personDto), HttpStatus.OK);
    }
}
