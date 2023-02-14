package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Enums.UserTypes;
import IS442_Quantum.backend.Model.User;
import IS442_Quantum.backend.Model.Vendor;
import IS442_Quantum.backend.Service.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Write a GetMapping to get all users by user type
    @GetMapping("/userType/{userType}")
    public ResponseEntity<List<User>> getAllUsersByUserType(@PathVariable UserTypes userType){
        List<User> users = userService.findByUserType(userType);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @PostMapping("/vendor")
    public Vendor createVendor(@RequestBody Vendor vendor){
        return userService.createVendor(vendor);
    }
}
