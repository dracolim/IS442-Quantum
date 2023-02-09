package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Model.User;
import IS442_Quantum.backend.Repository.UserRepository;
import IS442_Quantum.backend.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

//    @GetMapping("/users")
//    public Iterable<User> getAll() {
//        return userService.findAll();
//    }
    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.saveUser(user), null, HttpStatus.CREATED);
    }
}
