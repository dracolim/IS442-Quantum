package IS442_Quantum.backend.Service;

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

    public Question findByQuestionId(Long questionId){
        return questionRepository.findByQuestionId(questionId);
    }

    public Iterable<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    public Question createNewQuestion(Question newQuestion){
        Question question = new Question();
        question.setInputLabel(newQuestion.getInputLabel());
        question.setInputType(newQuestion.getInputType());
        question.setAttribute(newQuestion.getAttribute());
        question.setIsRequired(newQuestion.getIsRequired());
        List<QuestionProperty> questionProperties = new ArrayList<>();
        for (QuestionProperty questionProperty : newQuestion.getQuestionProperties()) {
            QuestionProperty newQuestionProperty = new QuestionProperty();
            newQuestionProperty.setLabel(questionProperty.getLabel());
            newQuestionProperty.setQuestion(question);
            questionProperties.add(newQuestionProperty);
        }
        question.getQuestionProperties().addAll(questionProperties);
        return questionRepository.save(question);
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
        eQuestion.setIsRequired(question.getIsRequired());

        // update question properties if there is any question properties
        if (question.getQuestionProperties() != null) {

            List<QuestionProperty> questionProperties = question.getQuestionProperties();

            // Remove all question properties
            eQuestion.getQuestionProperties().clear();

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

            // set new question properties
            eQuestion.getQuestionProperties().addAll(updatedQuestionProperty);
        }

        return questionRepository.save(eQuestion);
    }

}
