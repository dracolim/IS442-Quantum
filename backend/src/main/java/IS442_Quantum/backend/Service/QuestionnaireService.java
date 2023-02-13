package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Questionnaire;
import IS442_Quantum.backend.Repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public Questionnaire findByQuestionnaireId(Long questionnaireId){
        return questionnaireRepository.findByQuestionnaireId(questionnaireId);
    }

    public Iterable<Questionnaire>getAllQuestionnaires(){
        return questionnaireRepository.findAll();
    }

    public Questionnaire createNewQuestionnaires(Questionnaire newQuestionnaire){
        return questionnaireRepository.save(newQuestionnaire);
    }

}
