package IS442_Quantum.backend.Model;
import IS442_Quantum.backend.Enums.UserTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="userType")
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "userType", insertable = false, updatable = false)
    private UserTypes userType;

    private String userName;
    private String emailAddress;
    private String password;
}
