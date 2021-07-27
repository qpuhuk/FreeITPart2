package HomeWorks.HW5.hibernate.service;

import HomeWorks.HW5.hibernate.controller.dto.AddressDto;
import HomeWorks.HW5.hibernate.controller.dto.UserDto;
import HomeWorks.HW5.hibernate.dao.AddressRepository;
import HomeWorks.HW5.hibernate.dao.UserDao;
import HomeWorks.HW5.hibernate.dao.UserRepository;
import HomeWorks.HW5.hibernate.dao.entities.AddressEntity;
import HomeWorks.HW5.hibernate.dao.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDao userDao, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userDao = userDao;
    }

    private UserDto createDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setAge(userEntity.getAge());
        userDto.setName(userEntity.getName());
        AddressDto addressDto = new AddressDto(userEntity.getAddress().getId(), userEntity.getAddress().getCity(), userEntity.getAddress().getStreet());
        userDto.setAddress(addressDto);
        return userDto;
    }

    @Override
    public UserDto findByIdHibernate(int id) {
        UserEntity userEntity = userDao.findById(id);
        if (userEntity != null) {
            return createDto(userEntity);
        } else return null;

    }

    @Override
    public List<UserDto> findAllUserByAddress(AddressDto addressDto) {
        List<UserDto> allUsersDto = null;
        AddressEntity address = new AddressEntity();
        address.setId(addressDto.getId());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        List<UserEntity> users = userRepository.findUserEntityByAddress(address);
        if (Objects.nonNull(users)) {
            users.forEach(userEntity -> allUsersDto.add(createDto(userEntity)));
        }
        return allUsersDto;
    }

    @Override
    public UserDto create(UserDto userDto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(userDto.getAddress().getStreet());
        addressEntity.setCity(userDto.getAddress().getCity());
        addressRepository.save(addressEntity);
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(userDto.getAge());
        userEntity.setName(userDto.getName());
        userEntity.setAddress(addressEntity);
        userRepository.save(userEntity);
        return userDto;
    }

    @Override
    public UserDto findById(int id) {
        UserEntity userEntity = userRepository.findById(id);
        return createDto(userEntity);
    }
}
