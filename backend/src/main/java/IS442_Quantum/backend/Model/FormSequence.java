package IS442_Quantum.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class FormSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int formSequenceId;

    @ManyToOne
    @MapsId("workFlowId")
    @JoinColumn(name="workFlow_id")
    private WorkFlow workFlow;
    @ManyToOne
    @MapsId("formId")
    @JoinColumn(name="form_id")
    private Form form;
    private int seqNo;
    private boolean isApproved;
    private int approvalId;

    public FormSequence(){

    }
}