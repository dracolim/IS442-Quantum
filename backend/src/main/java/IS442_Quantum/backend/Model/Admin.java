package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@DiscriminatorValue("ADMIN")
@NoArgsConstructor
public class Admin extends User{
    @JsonIgnore
    @OneToMany(mappedBy = "admin", cascade = {CascadeType.ALL})
    private Set<WorkFlow> workFlows;
}
