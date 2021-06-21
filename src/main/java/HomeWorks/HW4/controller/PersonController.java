package HomeWorks.HW4.controller;

import HomeWorks.HW4.controller.dto.PersonDto;
import HomeWorks.HW4.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/people")
@AllArgsConstructor
@NoArgsConstructor
public class PersonController {
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        return new ResponseEntity<>(personService.createPerson(personDto), HttpStatus.OK);
    }
}
