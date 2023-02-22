package IS442_Quantum.backend.Service.Implementation;

import IS442_Quantum.backend.Enums.UserTypes;
import IS442_Quantum.backend.Model.User;
import IS442_Quantum.backend.Model.Vendor;
import IS442_Quantum.backend.Model.WorkFlow;
import IS442_Quantum.backend.Repository.UserRepository;
import IS442_Quantum.backend.Service.WorkFlowService;
import IS442_Quantum.backend.Service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Vendor createVendor(Vendor vendor){
        return userRepository.save(vendor);
    }

    @Override
    public User updateUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id){
       return userRepository.findById(id);
    }


    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findByUserType(UserTypes userType) {
        return userRepository.findByUserType(userType);
    }

    @Override
    public void addWorkflowToVendor(Long userId, WorkFlow workFlow) {
        Vendor vendor = (Vendor) userRepository.findById(userId).get();
        vendor.addWorkflow(workFlow);
        userRepository.save(vendor);
    }

}
