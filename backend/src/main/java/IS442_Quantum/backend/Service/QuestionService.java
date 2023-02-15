package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question findByQuestion(Long questionId){
        return questionRepository.findByQuestionId(questionId);
    }

    public Iterable<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    public Question createNewQuestion(Question newQuestion){
        return questionRepository.save(newQuestion);
    }

    public void deleteQuestionById(Long id){
        questionRepository.deleteById(id);
    }

    public boolean checkQuestionById(Long id){
        return questionRepository.existsById(id);
    }

    public Question editQuestionById(Long id, Question newQuestion){
        return questionRepository.findById(id).map(question -> {
            question.setInputLabel(newQuestion.getInputLabel());
            question.setInputType(newQuestion.getInputType());
            question.setAttribute(newQuestion.getAttribute());
//            question.setQuestionProperties(newQuestion.getQuestionProperties());
            return questionRepository.save(question);

        }).orElseGet(()->{
            newQuestion.setQuestionId(id);
            return questionRepository.save(newQuestion);
        });
    }

}
