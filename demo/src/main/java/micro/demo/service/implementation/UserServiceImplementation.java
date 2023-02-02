package micro.demo.service.implementation;

import lombok.RequiredArgsConstructor;
import micro.demo.entity.Users;
import micro.demo.repository.UserRepository;
import micro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Users addUser(Users user) {
        String pw = user.getPassword();
        user.setPassword(passwordEncoder.encode(pw));
        return userRepository.save(user);
    }
    @Override
    public Users updateUser(Long id, Users user) {
        Users userWithId= userRepository.findById(id).orElse(null);
        if(userWithId != null ){
            userWithId.setFirstName(user.getFirstName());
            userWithId.setLastName(user.getLastName());
            userWithId.setUsername(user.getUsername());
            userWithId.setEmail(user.getEmail());
            userWithId.setPassword(user.getPassword());
            userWithId.setReference(user.getReference());
            return userWithId;
        }else{
            throw new IllegalStateException("user cannot be found");
        }
    }

    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }
    @Override
    public Users loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
