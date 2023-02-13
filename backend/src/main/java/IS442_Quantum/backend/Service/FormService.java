package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.FormQuestion;
import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private QuestionService questionService;

    public Form createNewForm(Form form){
        Form newForm = new Form();
        newForm.setFormName(form.getFormName());
        newForm.setDateSubmitted(form.getDateSubmitted());
        newForm.setLastEdited(form.getLastEdited());
        newForm.getFormQuestions().addAll(form.getFormQuestions().stream().map(formQuestion -> {
            Question question = questionService.findByQuestionnaireId(formQuestion.getQuestion().getQuestionId());
            FormQuestion newFormQuestion = new FormQuestion();
            newFormQuestion.setForm(newForm);
            newFormQuestion.setQuestion(question);
            newFormQuestion.setInputValue(formQuestion.getInputValue());
            return newFormQuestion;
        }).toList()
        );
        return formRepository.save(newForm);
    }

    public Collection<Form> getAllForm(){
        return formRepository.findAll();
    }

}
