package IS442_Quantum.backend.Repository;

import IS442_Quantum.backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
