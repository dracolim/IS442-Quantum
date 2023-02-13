package IS442_Quantum.backend.Repository;

import IS442_Quantum.backend.Model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnairesRepository extends JpaRepository<Questionnaire, Long> {
    Questionnaire findByQId(Long qId);
}
