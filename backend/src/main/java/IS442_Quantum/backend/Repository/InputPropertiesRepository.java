package IS442_Quantum.backend.Repository;

import IS442_Quantum.backend.Model.InputProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputPropertiesRepository extends JpaRepository<InputProperties, Long> {
    InputProperties findByInputId(Long inputId);
}
