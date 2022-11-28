package id.maybank.MyFirstApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import id.maybank.MyFirstApp.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
