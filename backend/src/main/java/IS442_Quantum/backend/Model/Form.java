package IS442_Quantum.backend.Model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formId;
    private String formName;
    private Date dateSubmitted;
    private Date lastEdited;

    @OneToMany(mappedBy="form", cascade={CascadeType.ALL})
    private Collection<FormQuestionnaire> formQuestionnaires = new ArrayList<>();

    public void addFormQuestionnaire(FormQuestionnaire fq){
        formQuestionnaires.add(fq);
        fq.setForm(this);
    }
}
