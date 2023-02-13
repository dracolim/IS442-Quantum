package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.FormQuestionnaire;
import IS442_Quantum.backend.Model.Questionnaire;
import IS442_Quantum.backend.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private QuestionnaireService questionnaireService;

    public Form createNewForm(Form form){
        Form newForm = new Form();
        newForm.setFormName(form.getFormName());
        newForm.setDateSubmitted(form.getDateSubmitted());
        newForm.setLastEdited(form.getLastEdited());
        newForm.getFormQuestionnaires().addAll(form.getFormQuestionnaires().stream().map(formQuestionnaire -> {
            Questionnaire questionnaire = questionnaireService.findByQuestionnaireId(formQuestionnaire.getQuestionnaire().getQuestionnaireId());
            FormQuestionnaire newFormQuestionnaire = new FormQuestionnaire();
            newFormQuestionnaire.setForm(newForm);
            newFormQuestionnaire.setQuestionnaire(questionnaire);
            newFormQuestionnaire.setInputValue(formQuestionnaire.getInputValue());
            return newFormQuestionnaire;
        }).toList()
        );
        return formRepository.save(newForm);
    }

    public Collection<Form> getAllForm(){
        return formRepository.findAll();
    }

}
