package IS442_Quantum.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@Data
public class InputProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long input_id;
    private String input_type;
    private String attribute_type;
    private String input_label;
    private Boolean is_required;

    @OneToMany(mappedBy = "inputProperty", cascade = CascadeType.ALL)
    private ArrayList<FormInput> formInputs;

    public InputProperties(String input_type, String attribute_type, String input_label, Boolean is_required, ArrayList<FormInput> formInputs) {
        this.input_type = input_type;
        this.attribute_type = attribute_type;
        this.input_label = input_label;
        this.is_required = is_required;
        this.formInputs = formInputs;
    }
}
