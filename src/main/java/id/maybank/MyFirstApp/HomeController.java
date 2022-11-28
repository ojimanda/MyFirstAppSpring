package id.maybank.MyFirstApp;

import id.maybank.MyFirstApp.dto.UserDTO;
import id.maybank.MyFirstApp.entity.User;
import id.maybank.MyFirstApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/main")
    public String Main() {
        return "Main";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping
    public String authentication(UserDTO userDTO) {
        List<User> userList = userService.listOfUser();
        int check = 0;
        for(User user: userList) {
//            log.info(user.getUsername().toString() + " "+ user.getPassword());
            if(Objects.equals(user.getUsername(), userDTO.getUsername()) && Objects.equals(user.getPassword(), userDTO.getPassword())) {
                check = 1;
            }
        }
        if(check == 1) {
            return "redirect:/admin/" ;
        }else {
            return "redirect:/";
        }
    }
}
