package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FormSequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int formSequenceId;

    @ManyToOne
    @MapsId("workFlowId")
    @JoinColumn(name="workFlow_id")
    @JsonIgnore
    private WorkFlow workFlow;

    @ManyToOne
    @MapsId("formId")
    @JoinColumn(name="form_id")
    private Form form;

    private int seqNo;
    private boolean isApproved;
    private int approvalId;

}
