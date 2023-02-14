package IS442_Quantum.backend.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("APPROVER")
@NoArgsConstructor
public class Approver extends User{

}
