package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class FormQuestionnaires {

    @EmbeddedId
    private FormQId formQId = new FormQId();

    @ManyToOne
    @MapsId("formId")
    @JoinColumn(name="form_id")
    @JsonIgnore
    private Form form;

    @ManyToOne
    @MapsId("qId")
    @JoinColumn(name="questionnaires_id")
    private Questionnaires questionnaires;

    private String inputValue;

}
