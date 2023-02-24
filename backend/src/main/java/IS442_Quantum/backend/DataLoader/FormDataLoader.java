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


        // ------------------------ New Vendor Assessment Form --------------------------
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
        q9.setInputLabel("Evaluation");
        q9.setInputType("checkbox");
        q9.setAttribute("hidden");
        q9.setIsRequired(true);
        q9.addList(new QuestionProperty("IS9001 Certification"));
        q9.addList(new QuestionProperty("Accreditation of Laboratory"));
        q9.addList(new QuestionProperty("Product Certification"));
        q9.addList(new QuestionProperty("Results of Samples/Product Evaluation"));
        q9.addList(new QuestionProperty("Results of First Deal"));
        q9.addList(new QuestionProperty("Results of Track Record Review/Customer Reference"));
        q9.addList(new QuestionProperty("Others"));

        Question q9a = new Question();
        q9a.setInputLabel("Certification Body");
        q9a.setInputType("text");
        q9.setAttribute("hidden");
        q9a.setIsRequired(true);

        Question q10 = new Question();
        q10.setInputLabel("Accreditation of Body");
        q10.setInputType("text");
        q9.setAttribute("hidden");
        q10.setIsRequired(true);

        questionRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5,q6,q7,q7a,q8,q9,q9a,q10));

        Form newVendorAssessmentForm = new Form();
        newVendorAssessmentForm.setFormName("New Vendor Assessment Form");

        Long millis = System.currentTimeMillis();
        java.sql.Date formDate = new java.sql.Date(millis);
        newVendorAssessmentForm.setDateSubmitted(formDate);
        newVendorAssessmentForm.setLastEdited(formDate);

        formRepository.save(newVendorAssessmentForm);

        Question[] questions = {q1,q2,q3,q4,q5,q6,q7,q7a,q8,q9,q9a,q10};

        for (Question q : questions){
            FormQuestion newFq = new FormQuestion();
            newFq.setForm(newVendorAssessmentForm);
            newFq.setQuestion(q);
            newVendorAssessmentForm.addFormQuestionnaire(newFq);
        }

        formRepository.save(newVendorAssessmentForm);

        // --------- Subcontractor's Safety & Health pre-evaluation -------------

        Question f2q1 = new Question();
        f2q1.setInputLabel("Name of Sub-Contractor");
        f2q1.setInputType("text");
        f2q1.setIsRequired(true);

        Question f2q2 = new Question();
        f2q2.setInputLabel("Scope of Work");
        f2q2.setInputType("text");
        f2q2.setIsRequired(true);

        Question f2q3 = new Question();
        f2q3.setInputLabel("Evaluated By");
        f2q3.setInputType("text");
        f2q3.setIsRequired(true);

        Question f2q4 = new Question();
        f2q4.setInputLabel("Date");
        f2q4.setInputType("Date");
        f2q4.setIsRequired(true);

        Question f2q5 = new Question();
        f2q5.setInputLabel("Is there a written Safety & Health Policy?");
        addYesNoRadio(f2q5);
        f2q5.setIsRequired(true);

        Question f2q6 = new Question();
        f2q6.setInputLabel("Is there a Safety Organisation with proper delegation of responsibility and accountability for safety and health?");
        addYesNoRadio(f2q6);
        f2q6.setIsRequired(true);

        Question f2q7 = new Question();
        f2q7.setInputLabel("Is there a written safety commitment and is it submitted?");
        addYesNoRadio(f2q7);
        f2q7.setIsRequired(true);

        Question f2q8 = new Question();
        f2q8.setInputLabel("Are relevant safety training courses provided for management/Supervisors?");
        addYesNoRadio(f2q8);
        f2q8.setIsRequired(true);

        Question f2q9 = new Question();
        f2q9.setInputLabel("Are relevant safety training courses provided for workers?");
        addYesNoRadio(f2q9);
        f2q9.setIsRequired(true);

        Question f2q10 = new Question();
        f2q10.setInputLabel("Are relevant safety training certificates submitted?");
        addYesNoRadio(f2q10);
        f2q10.setIsRequired(true);

        Question f2q11 = new Question();
        f2q11.setInputLabel("Are there written safety & health rules for the workers?");
        addYesNoRadio(f2q11);
        f2q11.setIsRequired(true);

        Question f2q12 = new Question();
        f2q12.setInputLabel("Are there written safe work procedures/ risk assessment formulated and submitted?");
        addYesNoRadio(f2q12);
        f2q12.setIsRequired(true);

        Question f2q13 = new Question();
        f2q13.setInputLabel("Is there a written programme outlining inspection guidelines, frequency and follow-up corrective actions?");
        addYesNoRadio(f2q13);
        f2q13.setIsRequired(true);

        Question f2q14 = new Question();
        f2q14.setInputLabel("Is there available Personal Protective Equipment and of proper working condition and comply to safety requirements?");
        addYesNoRadio(f2q14);
        f2q14.setIsRequired(true);

        Question f2q15 = new Question();
        f2q15.setInputLabel("Is there a Safety Supervisor working at least 5 hrs / week?");
        addYesNoRadio(f2q15);
        f2q15.setIsRequired(true);

        Question f2q16 = new Question();
        f2q16.setInputLabel("Is there a qualified First Aider?");
        addYesNoRadio(f2q16);
        f2q16.setIsRequired(true);

        Question f2q17 = new Question();
        f2q17.setInputLabel("Are there relevant Licensed Electrical Workers, qualified engineers, qualified supervisors, lifting supervisors, qualified JCB Tower/Mobile/Crawler Crane operators?");
        addYesNoRadio(f2q17);
        f2q17.setIsRequired(true);

        Question f2q18 = new Question();
        f2q18.setInputLabel("Number of Temporary Disability Cases");
        f2q18.setInputType("number");
        f2q18.setIsRequired(true);

        Question f2q19 = new Question();
        f2q19.setInputLabel("Number of Permanent Disability Cases");
        f2q19.setInputType("number");
        f2q19.setIsRequired(true);

        Question f2q20 = new Question();
        f2q20.setInputLabel("Number of Fatal Cases");
        f2q20.setInputType("number");
        f2q20.setIsRequired(true);

        questionRepository.saveAll(Arrays.asList(f2q1,f2q2,f2q3,f2q4,f2q5,f2q6,f2q7,f2q8,f2q9, f2q10, f2q11, f2q12, f2q13, f2q14, f2q15, f2q16, f2q17, f2q18, f2q19));

        Form subcontractorSafetyHealthEvaluationForm = new Form();
        subcontractorSafetyHealthEvaluationForm.setFormName("Subcontractor's Safety & Health Pre-Evaluation");

        subcontractorSafetyHealthEvaluationForm.setDateSubmitted(formDate);
        subcontractorSafetyHealthEvaluationForm.setLastEdited(formDate);

        formRepository.save(subcontractorSafetyHealthEvaluationForm);

        Question[] questions2 = {f2q1,f2q2,f2q3,f2q4,f2q5,f2q6,f2q7,f2q8,f2q9, f2q10, f2q11, f2q12, f2q13, f2q14, f2q15, f2q16, f2q17, f2q18, f2q19};

        for (Question q : questions2){
            FormQuestion newFq = new FormQuestion();
            newFq.setForm(subcontractorSafetyHealthEvaluationForm);
            newFq.setQuestion(q);
            subcontractorSafetyHealthEvaluationForm.addFormQuestionnaire(newFq);
        }

        formRepository.save(subcontractorSafetyHealthEvaluationForm);

    }

    public void addYesNoRadio(Question q){
        q.setInputType("Radio");
        q.addList(new QuestionProperty(("Yes")));
        q.addList(new QuestionProperty(("No")));

    }

}
