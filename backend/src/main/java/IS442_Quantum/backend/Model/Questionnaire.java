package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class Questionnaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionnairesId;
    private String inputType;
    private String attribute;
    private String inputLabel;
    private Boolean isRequired;

    @OneToMany(mappedBy = "questionnaires", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<FormQuestionnaires> formQuestionnaires = new ArrayList<>();




}
