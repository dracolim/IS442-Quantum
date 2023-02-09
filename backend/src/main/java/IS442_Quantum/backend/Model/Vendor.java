package IS442_Quantum.backend.Model;

import jakarta.persistence.Entity;
import IS442_Quantum.backend.Enums.UserTypes;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Vendor extends User {
    private String companyName;
    private String officeAddress;
    private String officeTel;
    private String officeFax;
    private Integer regNo;
    private String businessType;
    private Integer evaluationId;

    public Vendor(){
    }

    public Vendor(UserTypes userType, String userName, String emailAddress, String password, String companyName, String officeAddress, String officeTel, String officeFax, Integer regNo, String businessType, Integer evaluationId) {
        super(userType, userName, emailAddress, password);
        this.companyName = companyName;
        this.officeAddress = officeAddress;
        this.officeTel = officeTel;
        this.officeFax = officeFax;
        this.regNo = regNo;
        this.businessType = businessType;
        this.evaluationId = evaluationId;
    }
}
