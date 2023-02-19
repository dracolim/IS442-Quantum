package IS442_Quantum.backend.DataLoader;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.FormQuestion;
import IS442_Quantum.backend.Model.QuestionProperty;
import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Repository.FormRepository;
import IS442_Quantum.backend.Repository.QuestionRepository;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class FormDataLoader implements ApplicationRunner {

    private final FormRepository formRepository;

    private final QuestionRepository questionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public FormDataLoader(FormRepository formRepository, QuestionRepository questionRepository) {
        this.formRepository = formRepository;
        this.questionRepository = questionRepository;
    }


    @Override
    @Transactional
    public void run(ApplicationArguments args) {

        // Reset the auto-increment value of the form and question table
        formRepository.deleteAll();
        questionRepository.deleteAll();
        String resetFormRepositoryQuery = "ALTER TABLE form AUTO_INCREMENT = 1";
        String resetQuestionRepositoryQuery = "ALTER TABLE question AUTO_INCREMENT = 1";
        entityManager.createNativeQuery(resetFormRepositoryQuery).executeUpdate();
        entityManager.createNativeQuery(resetQuestionRepositoryQuery).executeUpdate();


        // insert data
        Question q1 = new Question();
        q1.setInputLabel("Company's Name");
        q1.setInputType("text");
        q1.setIsRequired(true);

        Question q2 = new Question();
        q2.setInputLabel("Company Registration No");
        q2.setInputType("text");
        q2.setIsRequired(true);

        Question q3 = new Question();
        q3.setInputLabel("Office Address");
        q3.setInputType("text");
        q3.setIsRequired(true);

        Question q4 = new Question();
        q4.setInputLabel("Telephone No");
        q4.setInputType("text");
        q4.setIsRequired(true);

        Question q5 = new Question();
        q5.setInputLabel("Fax No");
        q5.setInputType("text");
        q5.setIsRequired(false);

        Question q6 = new Question();
        q6.setInputLabel("Type of Business License / Registration");
        q6.setInputType("checkbox");
        q6.setIsRequired(true);

        q6.addList(new QuestionProperty("Sole proprietorship"));
        q6.addList(new QuestionProperty("Limited Company"));
        q6.addList(new QuestionProperty("Partnership Agreement"));
        q6.addList(new QuestionProperty("Others"));

        Question q7 = new Question();
        q7.setInputLabel("Nature of Business");
        q7.setInputType("checkbox");
        q7.setIsRequired(true);

        q7.addList(new QuestionProperty("Manufacturing"));
        q7.addList(new QuestionProperty("Agent/dealer"));
        q7.addList(new QuestionProperty("Distributor"));
        q7.addList(new QuestionProperty("Others"));

        Question q7a = new Question();
        q7a.setInputLabel("Nature of Business (others)");
        q7a.setInputType("text");
        q7a.setIsRequired(false);

        Question q8 = new Question();
        q8.setInputLabel("Product / Services");
        q8.setInputType("text");
        q8.setIsRequired(false);

        Question q9 = new Question();
        q9.setInputLabel("ISO 9001 Certification");
        q9.setInputType("radio");
        q9.setIsRequired(true);
        q9.addList(new QuestionProperty("Yes"));
        q9.addList(new QuestionProperty("No"));

        Question q9a = new Question();
        q9a.setInputLabel("Certification Body");
        q9a.setInputType("text");
        q9a.setIsRequired(true);

        Question q10 = new Question();
        q10.setInputLabel("Accreditation of Laboratory");
        q10.setInputType("radio");
        q10.setIsRequired(true);
        q10.addList(new QuestionProperty("Yes"));
        q10.addList(new QuestionProperty("No"));

        Question q10a = new Question();
        q10a.setInputLabel("Accreditation Body");
        q10a.setInputType("text");
        q10a.setIsRequired(true);

        questionRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5,q6,q7,q7a,q8,q9,q9a,q10,q10a));

        Form newVendorAssessmentForm = new Form();
        newVendorAssessmentForm.setFormName("New Vendor Assessment Form");

        Long millis = System.currentTimeMillis();
        java.sql.Date formDate = new java.sql.Date(millis);
        newVendorAssessmentForm.setDateSubmitted(formDate);
        newVendorAssessmentForm.setLastEdited(formDate);

        formRepository.save(newVendorAssessmentForm);

        Question[] questions = {q1,q2,q3,q4,q5,q6,q7,q7a,q8,q9,q9a,q10,q10a};

        for (Question q : questions){
            FormQuestion newFq = new FormQuestion();
            newFq.setForm(newVendorAssessmentForm);
            newFq.setQuestion(q);
            newVendorAssessmentForm.addFormQuestionnaire(newFq);
        }

        formRepository.save(newVendorAssessmentForm);

    }

}
