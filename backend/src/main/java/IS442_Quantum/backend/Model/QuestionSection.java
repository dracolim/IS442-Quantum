package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class QuestionSection {

    @EmbeddedId
    private QuestionSectionId questionSectionId = new QuestionSectionId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("sectionId")
    @JoinColumn(name="section_id")
    @JsonIgnore
    private Section section;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name="question_id")
    private Question question;

    private String inputValue;

}
