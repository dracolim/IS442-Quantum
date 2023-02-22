package IS442_Quantum.backend.Service.services;
import IS442_Quantum.backend.Enums.UserTypes;
import IS442_Quantum.backend.Model.User;
import IS442_Quantum.backend.Model.Vendor;
import IS442_Quantum.backend.Model.WorkFlow;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Vendor createVendor(Vendor vendor);

    User updateUser(User user);

    void addWorkflowToVendor(Long userId, WorkFlow workFlow);

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    void deleteUserById(Long id);

    List<User> findByUserType(UserTypes userType);
}
