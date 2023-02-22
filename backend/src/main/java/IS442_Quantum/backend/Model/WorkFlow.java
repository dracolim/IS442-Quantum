package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class WorkFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workFlowId;
    private String wfName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date wfDateline;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date wfLastSubmit;
    private boolean isValidated;

    @OneToMany(mappedBy="workFlow", cascade={CascadeType.ALL})
    private Collection<FormSequence> formSequences = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name="userId")
    private Vendor vendor;

    public boolean isValidated() {
        return isValidated;
    }
}
