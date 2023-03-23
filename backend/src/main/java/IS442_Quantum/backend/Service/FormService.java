package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Model.QuestionProperty;
import IS442_Quantum.backend.Model.Section;
import IS442_Quantum.backend.Repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FormService {

    private final FormRepository formRepository;
    private final QuestionService questionService;
    private final SectionService sectionService;

    public FormService(FormRepository formRepository, QuestionService questionService, SectionService sectionService) {
        this.formRepository = formRepository;
        this.questionService = questionService;
        this.sectionService = sectionService;
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

    public Form createUpdateForm(Form formBody, Long formId){

        // Add general information
        Form form = formId != null ? formRepository.findByFormId(formId) : new Form();
        form.setFormName(formBody.getFormName());
        form.setDateSubmitted(formBody.getDateSubmitted());
        form.setLastEdited(formBody.getLastEdited());

        form.getSections().clear();

        // Add section
        for(Section section : formBody.getSections()){
//            Section newSection = sectionService.findBySectionId(section.getSectionId()) != null ? sectionService.findBySectionId(section.getSectionId()) : new Section();
            Section newSection = new Section();
            newSection.setTitle(section.getTitle());
            newSection.setDescription(section.getDescription());
            newSection.setUserType(section.getUserType());
            newSection.setForm(form);

            newSection.getQuestions().clear();

            // add questions to the newly generated section
            for (Question question : section.getQuestions()){
//                Question newQuestion = question.getQuestionId() != null ? questionService.findByQuestionId(question.getQuestionId()) : questionService.createNewQuestion(question);
                Question newQuestion = questionService.createNewQuestion(question);
                newQuestion.setSection(newSection);
                newQuestion.setInputValue(question.getInputValue());
                newSection.getQuestions().add(newQuestion);
            }

            form.getSections().add(newSection);
        }

        return formRepository.save(form);

    }

    public Form cloneForm(Long id){
        Form form = new Form(formRepository.findByFormId(id));
        return formRepository.save(form);
    }


}
