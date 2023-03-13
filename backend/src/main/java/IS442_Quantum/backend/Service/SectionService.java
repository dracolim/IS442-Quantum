package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Model.Section;
import IS442_Quantum.backend.Repository.FormRepository;
import IS442_Quantum.backend.Repository.QuestionRepository;
import IS442_Quantum.backend.Repository.SectionRepository;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;
    private final FormRepository formRepository;
    private final QuestionService questionService;

    public SectionService(SectionRepository sectionRepository, FormRepository formRepository, QuestionService questionService) {
        this.sectionRepository = sectionRepository;
        this.formRepository = formRepository;
        this.questionService = questionService;
    }

    public Iterable<Section> getAllSections(){
        return sectionRepository.findAll();
    }

    public Section findBySectionId(Long sectionId){
        return sectionRepository.findBySectionId(sectionId);
    }

    public Section createNewSection(Long formId, Section sectionBody){

        // initialise new section and set title and description
        Section newSection = new Section();
        newSection.setTitle(sectionBody.getTitle());
        newSection.setDescription(sectionBody.getDescription());

        // add questions to section
        addNewQuestions(formId, newSection, sectionBody);

        return sectionRepository.save(newSection);
    }


    public Section addQuestions(Long formId, Long sectionId, Section sectionBody){
        addNewQuestions(formId, sectionRepository.findBySectionId(sectionId), sectionBody);
        return sectionRepository.save(sectionRepository.findBySectionId(sectionId));
    }

    public void addNewQuestions(Long formId, Section newSection, Section sectionBody){

        // Set section to form and form to section
        Form form = formRepository.findByFormId(formId);
        newSection.setForm(form);
        form.getSections().add(newSection);

        // add questions to section
        for (Question question : sectionBody.getQuestions()){
            Question newQuestion = questionService.createNewQuestion(question);
            newQuestion.setSection(newSection);
            newSection.getQuestions().add(newQuestion);
        }

    }

    // Update Section only allow modification of section body and its question, not the form assigned to it
    public Section updateSection(Long formId, Long SectionId, Section sectionBody){
        Section section = sectionRepository.findBySectionId(SectionId);
        section.setForm(formRepository.findByFormId(formId));
        section.setTitle(sectionBody.getTitle());
        section.setDescription(sectionBody.getDescription());
        if(sectionBody.getQuestions() != null){
            section.getQuestions().clear();
            for (Question question : sectionBody.getQuestions()){
                Question newQuestion = questionService.checkQuestionById(question.getQuestionId()) ? questionService.findByQuestionId(question.getQuestionId()) : questionService.createNewQuestion(question);
                newQuestion.setSection(section);
                section.getQuestions().add(newQuestion);
            }
        }
        return sectionRepository.save(section);
    }

    public void deleteSectionById(Long sectionId){
        sectionRepository.deleteById(sectionId);
    }

    public boolean checkSectionById(Long sectionId){
        return sectionRepository.existsById(sectionId);
    }



}
