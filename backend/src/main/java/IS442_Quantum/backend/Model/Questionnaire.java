package IS442_Quantum.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionnaireId;
    private String inputType;
    private String attribute;
    private String inputLabel;
    private Boolean isRequired;

    @OneToMany(mappedBy ="questionnaire", cascade = {CascadeType.ALL})
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<QuestionnaireList> questionnaireLists = new ArrayList<>();

    @OneToMany(mappedBy = "questionnaire", cascade = {CascadeType.ALL})
    @JsonIgnore
    private Collection<FormQuestionnaire> formQuestionnaires = new ArrayList<>();

    public void addList(QuestionnaireList questionnaireList){
        questionnaireLists.add(questionnaireList);
        questionnaireList.setQuestionnaire(this);
    }

    public void removeList(QuestionnaireList questionnaireList){
        questionnaireLists.remove(questionnaireList);
        questionnaireList.setQuestionnaire(null);
    }

}
