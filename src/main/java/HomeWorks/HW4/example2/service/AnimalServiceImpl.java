package HomeWorks.HW4.example2.service;

import HomeWorks.HW4.example2.controller.dto.AnimalDto;
import HomeWorks.HW4.example2.dao.AnimalDao;
import HomeWorks.HW4.example2.dao.entities.AnimalEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private AnimalDao dao;

    @Override
    public AnimalDto create(AnimalDto animalDto) {
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setName(animalDto.getName());
        animalEntity.setAge(animalDto.getAge());
        dao.save(animalEntity);
        return animalDto;
    }

    @Override
    public AnimalDto findByAge(int age) {
        AnimalEntity animalEntity = dao.findByAge(age);
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animalEntity.getId());
        animalDto.setAge(animalEntity.getAge());
        animalDto.setName(animalEntity.getName());
        return animalDto;
    }
}
