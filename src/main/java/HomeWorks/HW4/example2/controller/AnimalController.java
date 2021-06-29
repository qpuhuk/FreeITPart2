package HomeWorks.HW4.example2.controller;

import HomeWorks.HW4.example2.controller.dto.AnimalDto;
import HomeWorks.HW4.example2.dao.entities.AnimalEntity;
import HomeWorks.HW4.example2.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class AnimalController {
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalDto> createAnimal(@RequestBody AnimalDto animalDto) {
        return new ResponseEntity<>(animalService.create(animalDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<AnimalDto> find(int age) {
        return new ResponseEntity<>(animalService.findByAge(age), HttpStatus.OK);
    }
}
