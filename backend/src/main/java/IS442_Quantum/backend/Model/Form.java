package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import lombok.*;

@Entity
@Data
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formId;
    private String formName;
    private Date dateSubmitted;
    private Date lastEdited;

    @OneToMany(mappedBy="form", cascade={CascadeType.ALL})
    private Collection<FormInput> formInputs = new ArrayList<>();

}
