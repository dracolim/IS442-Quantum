package IS442_Quantum.backend.Model;
import IS442_Quantum.backend.Enums.UserTypes;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="userType")
public abstract class User {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "userType", insertable = false, updatable = false)
    protected UserTypes userType;

    protected String userName;
    protected String emailAddress;
    protected String password;
}
