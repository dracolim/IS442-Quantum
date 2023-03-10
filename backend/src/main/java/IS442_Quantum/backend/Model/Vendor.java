package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("VENDOR")
public class Vendor extends User{
    private String companyName;
    private String officeAddress;
    private String officeTel;
    private String officeFax;
    private Long registrationNo;
    private String businessType;
    private String evaluationId;
    @JsonIgnore
    @OneToMany(mappedBy = "vendor", cascade = {CascadeType.ALL})
    private Set<WorkFlow> workFlows;

    public void addWorkflow(WorkFlow workFlow) {
        if (workFlow != null) {
            if (workFlows == null) {
                workFlows = new HashSet<>();
            }
            workFlow.setVendor(this);
            workFlows.add(workFlow);
        }
    }
}
