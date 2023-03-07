package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class QuestionProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    @JsonIgnore
    private Question question;
    public QuestionProperty(String label) {
        this.label = label;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof QuestionProperty)) return false;
        return id != null && id.equals(((QuestionProperty) o).getId());
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
