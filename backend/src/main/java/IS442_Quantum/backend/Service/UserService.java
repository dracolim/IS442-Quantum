package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Enums.UserTypes;
import IS442_Quantum.backend.Model.User;
import IS442_Quantum.backend.Model.Vendor;
import IS442_Quantum.backend.Model.WorkFlow;
import IS442_Quantum.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public Vendor createVendor(Vendor vendor){
        return userRepository.save(vendor);
    }

    public User updateUser(User user){
        // spring JPA .save() will update the existing user if the id is present
        // instead of creating a brand-new user in the db
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> findUserById(Long id){
       return userRepository.findById(id);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> findByUserType(UserTypes userType) {
        return userRepository.findByUserType(userType);
    }
    public void addWorkflowToVendor(Long userId, WorkFlow workFlow) {
        Vendor vendor = (Vendor) userRepository.findById(userId).get();
        vendor.addWorkflow(workFlow);
        userRepository.save(vendor);
    }

}
