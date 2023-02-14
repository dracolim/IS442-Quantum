package IS442_Quantum.backend.Service.services;
import IS442_Quantum.backend.Enums.UserTypes;
import IS442_Quantum.backend.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    User updateUser(User user);

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    void deleteUserById(Long id);

    List<User> findByUserType(UserTypes userType);
}
