package IS442_Quantum.backend.Repository;

import IS442_Quantum.backend.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findByQuestionId(Long questionId);

}
