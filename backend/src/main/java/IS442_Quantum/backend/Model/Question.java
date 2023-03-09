package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    // copy constructor
    public Question(Question question) {
        this.inputType = question.getInputType();
        this.attribute = question.getAttribute();
        this.inputLabel = question.getInputLabel();
        this.isRequired = question.getIsRequired();
        this.inputValue = question.getInputValue();
        for(QuestionProperty questionProperty : question.getQuestionProperties()){
            addQuestionProperties(new QuestionProperty(questionProperty));
        }
    }

    public void addQuestionProperties(QuestionProperty questionProperty){
        questionProperties.add(questionProperty);
        questionProperty.setQuestion(this);
    }

}
