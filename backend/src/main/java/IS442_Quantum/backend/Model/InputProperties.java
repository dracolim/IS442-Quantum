package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class InputProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inputId;
    private String inputType;
    private String attribute;
    private String inputLabel;
    private Boolean isRequired;

    @OneToMany(mappedBy = "inputProperty", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<FormInput> formInputs = new ArrayList<>();




}
