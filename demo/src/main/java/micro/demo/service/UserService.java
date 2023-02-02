package micro.demo.service;

import micro.demo.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Users addUser(Users user);

    Users updateUser(Long id, Users user);

    List<Users> getAll();

    Users loadUserByUsername(String username);
}
