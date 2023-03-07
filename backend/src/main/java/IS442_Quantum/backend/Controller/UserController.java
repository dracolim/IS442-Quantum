package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Enums.UserTypes;
import IS442_Quantum.backend.Model.*;
import IS442_Quantum.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        try {
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor){
        try {
            userService.createVendor(vendor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/vendor/{userId}")
    public ResponseEntity<User> addWorkflowToVendor(@PathVariable Long userId, @RequestBody WorkFlow workflow){
        try {
            userService.addWorkflowToVendor(userId, workflow);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/vendor")
    public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor updatedVendor) {
        try {
            userService.updateUser(updatedVendor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/admin")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin updatedAdmin) {
        try {
            userService.updateUser(updatedAdmin);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/approver")
    public ResponseEntity<Approver> updateApprover(@RequestBody Approver updatedApprover) {
        try {
            userService.updateUser(updatedApprover);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
