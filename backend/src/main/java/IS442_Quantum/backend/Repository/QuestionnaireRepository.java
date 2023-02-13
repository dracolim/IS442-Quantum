package IS442_Quantum.backend.Repository;

import IS442_Quantum.backend.Model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
    Questionnaire findByQuestionnaireId(Long questionnaireId);
}
