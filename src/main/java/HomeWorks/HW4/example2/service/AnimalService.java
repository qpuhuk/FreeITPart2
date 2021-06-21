package HomeWorks.HW4.example2.service;

import HomeWorks.HW4.example2.controller.dto.AnimalDto;
import HomeWorks.HW4.example2.dao.entities.AnimalEntity;

public interface AnimalService {
    AnimalDto create(AnimalDto animalDto);

    AnimalEntity findByAge(int age);
}
