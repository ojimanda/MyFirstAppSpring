package id.maybank.MyFirstApp.controller;


import id.maybank.MyFirstApp.dto.UserDTO;
import id.maybank.MyFirstApp.entity.User;
import id.maybank.MyFirstApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> listOfUser() {
        return userService.listOfUser();
    }
    @PostMapping("/add")
    public User addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable  Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

}
