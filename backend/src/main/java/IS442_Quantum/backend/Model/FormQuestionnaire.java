package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class FormQuestionnaire {

    @EmbeddedId
    private FormQId formQId = new FormQId();

    @ManyToOne
    @MapsId("formId")
    @JoinColumn(name="form_id")
    @JsonIgnore
    private Form form;

    @ManyToOne
    @MapsId("questionnaireId")
    @JoinColumn(name="questionnaire_id")
    private Questionnaire questionnaire;

    private String inputValue;

    public FormQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }


}
