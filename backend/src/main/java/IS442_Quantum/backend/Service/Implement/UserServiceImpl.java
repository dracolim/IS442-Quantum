package IS442_Quantum.backend.Service.Implement;

import IS442_Quantum.backend.Model.User;
import IS442_Quantum.backend.Repository.UserRepository;
import IS442_Quantum.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }
}
