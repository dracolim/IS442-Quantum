package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.FormQuestion;
import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FormService {

    private FormRepository formRepository;

    private QuestionService questionService;

    public FormService(FormRepository formRepository, QuestionService questionService) {
        this.formRepository = formRepository;
        this.questionService = questionService;
    }

    public Form createNewForm(Form form){
        Form newForm = new Form();
        newForm.setFormName(form.getFormName());
        newForm.setDateSubmitted(form.getDateSubmitted());
        newForm.setLastEdited(form.getLastEdited());
        newForm.getFormQuestions().addAll(form.getFormQuestions().stream().map(formQuestion -> {
            if (formQuestion.getQuestion().getQuestionId()==null){
                questionService.createNewQuestion(formQuestion.getQuestion());
            }
                Question question = questionService.findByQuestion(formQuestion.getQuestion().getQuestionId());
                FormQuestion newFormQuestion = new FormQuestion();
                newFormQuestion.setForm(newForm);
                newFormQuestion.setQuestion(question);
                newFormQuestion.setInputValue(formQuestion.getInputValue());
                return newFormQuestion;
        }).toList());
        return formRepository.save(newForm);
    }

    public Collection<Form> getAllForm(){
        return formRepository.findAll();
    }

    public Optional<Form> getFormById(Long id){
        return formRepository.findById(id);
    }

    public void deleteFormById(Long id){
        formRepository.deleteById(id);
    }

    public boolean checkFormById(Long id){
        return formRepository.existsById(id);
    }


}
