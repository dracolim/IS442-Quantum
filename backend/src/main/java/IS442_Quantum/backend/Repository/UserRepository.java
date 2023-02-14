package IS442_Quantum.backend.Repository;

import IS442_Quantum.backend.Enums.UserTypes;
import IS442_Quantum.backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userType = :userType")
    List<User> findByUserType(UserTypes userType);

}
