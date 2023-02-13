package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class QuestionnaireList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="questionnaire_id")
    @JsonIgnore
    private Questionnaire questionnaire;


    public QuestionnaireList(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof QuestionnaireList)) return false;
        return id != null && id.equals(((QuestionnaireList) o).getId());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
