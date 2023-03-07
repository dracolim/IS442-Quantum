package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class QuestionValue {

    @EmbeddedId
    private QuestionValueId questionValueId = new QuestionValueId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("formId")
    @JoinColumn(name="form_id")
    @JsonIgnore
    private Form form;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name="question_id")
    @JsonIgnore
    private Question question;

    private String input_value;

    public QuestionValue(Form form, Question question) {
        this.form = form;
        this.question = question;
    }

}
