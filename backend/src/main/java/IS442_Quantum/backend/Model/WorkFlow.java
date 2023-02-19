package IS442_Quantum.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
public class WorkFlow {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int wfid;
    private String wfName;
    private Date wfDateline;
    private Date wfLastSubmit;
    private boolean isValidated;

    @OneToMany(mappedBy="workFlow", cascade={CascadeType.ALL})
    private Collection<FormSequence> formSequences = new ArrayList<>();

    public void addFormSequence(FormSequence fs){
        formSequences.add(fs);
        fs.setWorkFlow(this);
    }

    public WorkFlow(){

    };

    public Date getWfDateline() {
        return wfDateline;
    }

    public int getWfid() {
        return wfid;
    }

    public Date getWfLastSubmit() {
        return wfLastSubmit;
    }

    public String getWfName() {
        return wfName;
    }

    public boolean isValidated() {
        return isValidated;
    }



}
