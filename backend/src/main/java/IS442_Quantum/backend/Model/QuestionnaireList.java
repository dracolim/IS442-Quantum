package IS442_Quantum.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class QListValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qListValueId;

    private String label;

    @ManyToOne
    @MapsId("questionnaireId")
    @JoinColumn(name="questionnaire_id")
    private Questionnaire questionnaire;



}
