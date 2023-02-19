package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.FormQuestion;
import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Model.QuestionProperty;
import IS442_Quantum.backend.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

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

    public Question editQuestionById(Long id, Question question){
        Question eQuestion = questionRepository.findByQuestionId(id);
        eQuestion.setInputLabel(question.getInputLabel());
        eQuestion.setInputType(question.getInputType());
        eQuestion.setAttribute(question.getAttribute());

        // update question properties if there is any question properties
        if (question.getQuestionProperties() != null) {

            // Add new question properties
            List<QuestionProperty> updatedQuestionProperty = new ArrayList<>();
            for (QuestionProperty questionProperty : question.getQuestionProperties()){
                if (questionProperty.getId() != null) {
                    questionProperty.setQuestion(eQuestion);
                    questionProperty.setLabel(questionProperty.getLabel());
                    updatedQuestionProperty.add(questionProperty);
                } else {
                    QuestionProperty newQuestionProperty = new QuestionProperty();
                    newQuestionProperty.setQuestion(eQuestion);
                    newQuestionProperty.setLabel(questionProperty.getLabel());
                    updatedQuestionProperty.add(newQuestionProperty);
                }
            }
            eQuestion.setQuestionProperties(updatedQuestionProperty);
        }

        return questionRepository.save(eQuestion);
    }

}
