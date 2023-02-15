package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class FormQuestion {

    @EmbeddedId
    private FormQId formQId = new FormQId();

    @ManyToOne
    @MapsId("formId")
    @JoinColumn(name="form_id")
    @JsonIgnore
    private Form form;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name="question_id")
    private Question question;

    private String inputValue;

    public FormQuestion(Question question) {
        this.question = question;
    }


}
