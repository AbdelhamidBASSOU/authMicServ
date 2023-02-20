package micro.demo.resource;

import lombok.RequiredArgsConstructor;
import micro.demo.entity.Users;
import micro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping("/add")
    public Users addUser(@RequestBody Users user){
        return userService.addUser(user);
    }

    @PutMapping("/{user_id}")
    public Users updateUser(@PathVariable Long user_id, @RequestBody Users user){
        return userService.updateUser(user_id,user);}

    @GetMapping("/users")
    public List<Users> getUsers(){
        return userService.getAll();
    }

}
