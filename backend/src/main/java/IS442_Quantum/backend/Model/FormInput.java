package IS442_Quantum.backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class FormInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="form_id")
    private Form form;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="input_id")
    private InputProperties inputProperty;

    private String input_value;


}
