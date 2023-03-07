package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
        return null;
//        return updateFormMapping(form, newForm, 1);
    }

    // to edit existing form
    public Form editForm(Form form){
        Form eForm = getFormById(form.getFormId());
        return null;
//        return updateFormMapping(form, eForm, 2);
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
//    public Form updateFormMapping(Form form, Form eForm, Integer type){
//        eForm.setFormName(form.getFormName());
//        eForm.setDateSubmitted(form.getDateSubmitted());
//        eForm.setLastEdited(form.getLastEdited());
//        if (type == 1){
//            eForm.getFormQuestions().addAll(form.getFormQuestions().stream().map(formQuestion -> {
//                Question generatedQuestion;
//                if (formQuestion.getQuestion().getQuestionId()==null){
//                    generatedQuestion = questionService.createNewQuestion(formQuestion.getQuestion());
//                } else {
//                    generatedQuestion = questionService.findByQuestion(formQuestion.getQuestion().getQuestionId());
//                }
//                Question question = questionService.findByQuestion(generatedQuestion.getQuestionId());
//                QuestionSection newQuestionSection = new QuestionSection();
//                newQuestionSection.setForm(eForm);
//                newQuestionSection.setQuestion(question);
//                newQuestionSection.setInputValue(formQuestion.getInputValue());
//                return newQuestionSection;
//            }).toList());
//        } else {
//            ArrayList<QuestionSection> updatedQuestionSections = new ArrayList<>();
//            for (QuestionSection questionSection : form.getFormQuestions()) {
//                Question generatedQuestion;
//                if (questionSection.getQuestion().getQuestionId()==null){
//                    generatedQuestion = questionService.createNewQuestion(questionSection.getQuestion());
//                } else {
//                    generatedQuestion = questionService.findByQuestion(questionSection.getQuestion().getQuestionId());
//                }
//                Question question = questionService.findByQuestion(generatedQuestion.getQuestionId());
//                QuestionSection existingQuestionSection = eForm.getFormQuestions().stream()
//                        .filter(fq -> fq.getFormQId().equals(questionSection.getFormSectionId()))
//                        .findFirst().orElse(null);
//                if (existingQuestionSection == null) {
//                    QuestionSection newQuestionSection = new QuestionSection();
//                    newQuestionSection.setForm(eForm);
//                    newQuestionSection.setQuestion(question);
//                    newQuestionSection.setInputValue(questionSection.getInputValue());
//                    updatedQuestionSections.add(newQuestionSection);
//                } else {
//                    existingQuestionSection.setQuestion(question);
//                    existingQuestionSection.setInputValue(questionSection.getInputValue());
//                    updatedQuestionSections.add(existingQuestionSection);
//                }
//            }
//            eForm.setFormQuestions(updatedQuestionSections);
//        }
//        return formRepository.save(eForm);
//    }

}
