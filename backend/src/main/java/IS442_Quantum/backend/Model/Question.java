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

    @OneToMany(mappedBy ="question", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<QuestionProperty> questionProperties = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL})
    @JsonIgnore
    private Collection<FormQuestion> formQuestions = new ArrayList<>();

    public void addList(QuestionProperty questionProperty){
        questionProperties.add(questionProperty);
        questionProperty.setQuestion(this);
    }

    public void removeList(QuestionProperty questionProperty){
        questionProperties.remove(questionProperty);
        questionProperty.setQuestion(null);
    }

}
