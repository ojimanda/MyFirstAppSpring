package id.maybank.MyFirstApp.service;


import id.maybank.MyFirstApp.dto.UserDTO;
import id.maybank.MyFirstApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> listOfUser();

    Optional<User> getUser(Long id);

    User addUser(UserDTO userDTO);

    String deleteUser(Long id);

    User updateUser(User user);

//    Boolean getUserAndPass(String username, String password);
}
