package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question findByQuestionnaireId(Long questionId){
        return questionRepository.findByQuestionId(questionId);
    }

    public Iterable<Question>getAllQuestionnaires(){
        return questionRepository.findAll();
    }

    public Question createNewQuestionnaires(Question newQuestion){
        return questionRepository.save(newQuestion);
    }

}
