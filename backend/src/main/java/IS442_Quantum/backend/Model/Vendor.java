package IS442_Quantum.backend.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vendor extends User{
    private String companyName;
    private String officeAddress;
    private String officeTel;
    private String officeFax;
    private Long registrationNo;
    private String businessType;
    private String evaluationId;
}
