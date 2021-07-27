package HomeWorks.HW5.hibernate.controller;

import HomeWorks.HW5.hibernate.controller.dto.AddressDto;
import HomeWorks.HW5.hibernate.controller.dto.UserDto;
import HomeWorks.HW5.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<UserDto> findByIdHibernate(@RequestParam Integer id) {
        return new ResponseEntity<>(userService.findByIdHibernate(id),HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<List<UserDto>> findAllUsersByAddress(@RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(userService.findAllUserByAddress(addressDto),HttpStatus.OK);
    }
}
