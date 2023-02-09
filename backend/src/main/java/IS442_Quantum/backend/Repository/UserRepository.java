package IS442_Quantum.backend.Repository;

import IS442_Quantum.backend.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository extends CrudRepository<User, Long> {
}
