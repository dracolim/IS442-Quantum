package IS442_Quantum.backend.Model;

import IS442_Quantum.backend.Enums.WorkFlowStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(50) default 'IN_PROGRESS'")
    private WorkFlowStatus workFlowStatus;

    @OneToMany(mappedBy="workFlow", cascade={CascadeType.ALL})
    private Collection<FormSequence> formSequences = new ArrayList<>();

    @ManyToOne(optional=true)
    @JoinColumn(name="vendorId", insertable=true, updatable=true)
    private Vendor vendor;

    @ManyToOne()
    @JoinColumn(name="adminId")
    private Admin admin;

    @ManyToOne(optional=true)
    @JoinColumn(name="approverId", insertable=true, updatable=true)
    private Approver approver;

    public void addFormSequence(FormSequence formSequence){
        formSequences.add(formSequence);
        formSequence.setWorkFlow(this);
    }

    public void removeFormSequence(FormSequence formSequence){
        formSequences.remove(formSequence);
        formSequence.setWorkFlow(null);
    }

//    public boolean isValidated() {
//        return isValidated;
//    }
}
