package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String inputType;
    private String attribute;
    private String inputLabel;
    private Boolean isRequired;
    private String inputValue;

    @OneToMany(mappedBy ="question", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<QuestionProperty> questionProperties = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="section_id")
    @JsonIgnore
    private Section section;

    public void addList(QuestionProperty questionProperty){
        questionProperties.add(questionProperty);
        questionProperty.setQuestion(this);
    }

    public void removeList(QuestionProperty questionProperty){
        questionProperties.remove(questionProperty);
        questionProperty.setQuestion(null);
    }

}
