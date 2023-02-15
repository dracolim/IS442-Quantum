package IS442_Quantum.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

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

    public WorkFlow(){

    };





}
