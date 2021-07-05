package HomeWorks.HW5.hibernate.service;

import HomeWorks.HW5.hibernate.controller.dto.AddressDto;
import HomeWorks.HW5.hibernate.controller.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto create (UserDto userDto);
    UserDto findById(int id);
    UserDto findByIdHibernate(int id);
    List<UserDto> findAllUserByAddress(AddressDto addressDto);
}
