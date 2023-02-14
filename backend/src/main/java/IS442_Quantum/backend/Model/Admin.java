package IS442_Quantum.backend.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("ADMIN")
@NoArgsConstructor
public class Admin extends User{
}
