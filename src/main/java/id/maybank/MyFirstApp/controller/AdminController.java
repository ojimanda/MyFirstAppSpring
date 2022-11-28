package id.maybank.MyFirstApp.controller;


import id.maybank.MyFirstApp.dto.UserDTO;
import id.maybank.MyFirstApp.entity.User;
import id.maybank.MyFirstApp.repository.UserRepository;
import id.maybank.MyFirstApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    private ModelMapper mapper = new ModelMapper();


    @GetMapping("/")
    public String listOfUser(Model model){
        List<User> users = userService.listOfUser();
        model.addAttribute("users", users);
        return "/admin/list";
    }

    @PostMapping("/addUser")
    public String addUser(UserDTO userDTO) {
//        repo.save(userDTO);
        userService.addUser(userDTO);
        return "redirect:/admin/";
    }
    @GetMapping("/addUser")
    public String addUser() {
        return "admin/formUser";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") Long id, Model model) {
        Optional<User> user = userService.getUser(id);
        model.addAttribute("user", user);
        return "admin/formUpdate";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/";
    }

}
