package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class FormInput {

    @EmbeddedId
    private FormInputId formInputId  = new FormInputId();

    @ManyToOne
    @MapsId("formId")
    @JoinColumn(name="form_id")
    @JsonIgnore
    private Form form;

    @ManyToOne
    @MapsId("inputId")
    @JoinColumn(name="input_id")
    private InputProperties inputProperty;

    private String inputValue;

}
