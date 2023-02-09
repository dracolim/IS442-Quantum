package IS442_Quantum.backend.Model;
import IS442_Quantum.backend.Enums.UserTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private UserTypes userType;
    private String userName;
    private String emailAddress;
    private String password;

    public User(){
    }

    public User(UserTypes userType, String userName, String emailAddress, String password) {
        this.userType = userType;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

}
