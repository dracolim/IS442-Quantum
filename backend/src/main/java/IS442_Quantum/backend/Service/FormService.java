package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.FormQuestion;
import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Repository.FormRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class FormService {

    private final FormRepository formRepository;

    private final QuestionService questionService;

    public FormService(FormRepository formRepository, QuestionService questionService) {
        this.formRepository = formRepository;
        this.questionService = questionService;
    }

    // creating new form
    public Form createNewForm(Form form){
        Form newForm = new Form();
        return updateFormMapping(form, newForm, 1);
    }

    // to edit existing form
    public Form editForm(Form form){
        Form eForm = getFormById(form.getFormId());
        return updateFormMapping(form, eForm, 2);
    }

    public Collection<Form> getAllForm(){
        return formRepository.findAll();
    }

    public Form getFormById(Long id){
        return formRepository.findByFormId(id);
    }

    public void deleteFormById(Long id){
        formRepository.deleteById(id);
    }

    public boolean checkFormById(Long id){
        return formRepository.existsById(id);
    }

    // mapping update for forms
    // Type 1 == create || Type 2 == Edit
    public Form updateFormMapping(Form form, Form eForm, Integer type){
        eForm.setFormName(form.getFormName());
        eForm.setDateSubmitted(form.getDateSubmitted());
        eForm.setLastEdited(form.getLastEdited());
        if (type == 1){
            eForm.getFormQuestions().addAll(form.getFormQuestions().stream().map(formQuestion -> {
                Question generatedQuestion;
                if (formQuestion.getQuestion().getQuestionId()==null){
                    generatedQuestion = questionService.createNewQuestion(formQuestion.getQuestion());
                } else {
                    generatedQuestion = questionService.findByQuestion(formQuestion.getQuestion().getQuestionId());
                }
                Question question = questionService.findByQuestion(generatedQuestion.getQuestionId());
                FormQuestion newFormQuestion = new FormQuestion();
                newFormQuestion.setForm(eForm);
                newFormQuestion.setQuestion(question);
                newFormQuestion.setInputValue(formQuestion.getInputValue());
                return newFormQuestion;
            }).toList());
        } else {
            ArrayList<FormQuestion> updatedFormQuestions = new ArrayList<>();
            for (FormQuestion formQuestion : form.getFormQuestions()) {
                Question generatedQuestion;
                if (formQuestion.getQuestion().getQuestionId()==null){
                    generatedQuestion = questionService.createNewQuestion(formQuestion.getQuestion());
                } else {
                    generatedQuestion = questionService.findByQuestion(formQuestion.getQuestion().getQuestionId());
                }
                Question question = questionService.findByQuestion(generatedQuestion.getQuestionId());
                FormQuestion existingFormQuestion = eForm.getFormQuestions().stream()
                        .filter(fq -> fq.getFormQId().equals(formQuestion.getFormQId()))
                        .findFirst().orElse(null);
                if (existingFormQuestion == null) {
                    FormQuestion newFormQuestion = new FormQuestion();
                    newFormQuestion.setForm(eForm);
                    newFormQuestion.setQuestion(question);
                    newFormQuestion.setInputValue(formQuestion.getInputValue());
                    updatedFormQuestions.add(newFormQuestion);
                } else {
                    existingFormQuestion.setQuestion(question);
                    existingFormQuestion.setInputValue(formQuestion.getInputValue());
                    updatedFormQuestions.add(existingFormQuestion);
                }
            }
            eForm.setFormQuestions(updatedFormQuestions);
        }
        return formRepository.save(eForm);
    }

}
