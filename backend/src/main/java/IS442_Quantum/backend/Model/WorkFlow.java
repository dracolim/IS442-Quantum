package IS442_Quantum.backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class WorkFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workFlowId;
    private String wfName;
    private Date wfDateline;
    private Date wfLastSubmit;
    private boolean isValidated;

    @OneToMany(mappedBy="workFlow", cascade={CascadeType.ALL})
    private Collection<FormSequence> formSequences = new ArrayList<>();

    public boolean isValidated() {
        return isValidated;
    }



}
