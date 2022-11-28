package id.maybank.MyFirstApp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    private String username;
    private String password;
    private String email;
    private String city;
    private String birthDay;
}
