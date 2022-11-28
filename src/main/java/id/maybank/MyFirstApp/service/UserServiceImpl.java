package id.maybank.MyFirstApp.service;

import id.maybank.MyFirstApp.dto.UserDTO;
import id.maybank.MyFirstApp.entity.User;
import id.maybank.MyFirstApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> listOfUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);
        userRepository.save(user);
        return user;
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User " + id +" got deleted";
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());

        if (optionalUser.isPresent()) {
            User oldUser = optionalUser.get();
            oldUser.setUsername(user.getUsername());
            oldUser.setPassword(user.getPassword());
            oldUser.setCity(user.getCity());
            oldUser.setEmail(user.getEmail());
            userRepository.save(oldUser);
            return oldUser;
        } else {
            return new User();
        }
    }


//    @Override
//    public Boolean getUserAndPass(String username, String password) {
//        return null;
//    }
}
