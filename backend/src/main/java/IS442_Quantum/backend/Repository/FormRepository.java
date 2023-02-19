package IS442_Quantum.backend.Repository;

import IS442_Quantum.backend.Model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
    Form findByFormId(Long formId);
}
