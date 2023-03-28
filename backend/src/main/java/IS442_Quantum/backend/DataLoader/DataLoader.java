package IS442_Quantum.backend.DataLoader;

import IS442_Quantum.backend.Enums.FormSequenceStatus;
import IS442_Quantum.backend.Enums.UserTypes;
import IS442_Quantum.backend.Model.*;
import IS442_Quantum.backend.Repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    private final FormRepository formRepository;

    private final QuestionRepository questionRepository;

    private final SectionRepository sectionRepository;

    private final UserRepository userRepository;

    private final FormSequenceRepository formSequenceRepository;

    private final WorkFlowRepository workFlowRepository;

    private final QuestionPropertyRepository questionPropertyRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public DataLoader(
            FormRepository formRepository,
            QuestionRepository questionRepository,
            SectionRepository sectionRepository,
            UserRepository userRepository,
            FormSequenceRepository formSequenceRepository,
            WorkFlowRepository workFlowRepository,
            QuestionPropertyRepository questionPropertyRepository
    ) {
        this.formRepository = formRepository;
        this.questionRepository = questionRepository;
        this.sectionRepository = sectionRepository;
        this.userRepository = userRepository;
        this.formSequenceRepository = formSequenceRepository;
        this.workFlowRepository = workFlowRepository;
        this.questionPropertyRepository = questionPropertyRepository;
    }


    @Override
    @Transactional
    public void run(ApplicationArguments args) {

        // Reset the auto-increment value of the form and question table
        formRepository.deleteAll();
        workFlowRepository.deleteAll();
        userRepository.deleteAll();
        questionPropertyRepository.deleteAll();
        questionRepository.deleteAll();
        sectionRepository.deleteAll();
        formSequenceRepository.deleteAll();


        String resetQuestionRepositoryQuery = "ALTER TABLE question AUTO_INCREMENT = 1";
        String resetSectionRepositoryQuery = "ALTER TABLE section AUTO_INCREMENT = 1";
        String resetFormRepositoryQuery = "ALTER TABLE form AUTO_INCREMENT = 1";
        String resetUserRepositoryQuery = "ALTER TABLE user AUTO_INCREMENT = 1";
        String resetFormSequenceRepositoryQuery = "ALTER TABLE form_sequence AUTO_INCREMENT = 1";
        String resetWorkFlowRepositoryQuery = "ALTER TABLE work_flow AUTO_INCREMENT = 1";
        String resetQuestionPropertyQuery = "ALTER TABLE question_property AUTO_INCREMENT = 1";

        entityManager.createNativeQuery(resetQuestionRepositoryQuery).executeUpdate();
        entityManager.createNativeQuery(resetSectionRepositoryQuery).executeUpdate();
        entityManager.createNativeQuery(resetFormRepositoryQuery).executeUpdate();
        entityManager.createNativeQuery(resetUserRepositoryQuery).executeUpdate();
        entityManager.createNativeQuery(resetFormSequenceRepositoryQuery).executeUpdate();
        entityManager.createNativeQuery(resetWorkFlowRepositoryQuery).executeUpdate();
        entityManager.createNativeQuery(resetQuestionPropertyQuery).executeUpdate();





        // ------------------------ New Vendor Assessment Form --------------------------

        // add questions
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
        q7a.setInputLabel("(Others) Nature of Business ");
        q7a.setInputType("text");
        q7a.setIsRequired(false);

        Question q8 = new Question();
        q8.setInputLabel("Product / Services");
        q8.setInputType("text");
        q8.setIsRequired(false);

        Question q9 = new Question();
        q9.setInputLabel("Evaluation");
        q9.setInputType("checkbox");
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
        q9a.setIsRequired(true);

        Question q10 = new Question();
        q10.setInputLabel("Accreditation of Body");
        q10.setInputType("text");
        q10.setIsRequired(true);

        Question q10a = new Question();
        q10a.setInputLabel("Product Markings (e.g. PSB, UL, TUV, etc.)");
        q10a.setInputType("text");
        q10a.setIsRequired(true);

        Question adminSignature1 = new Question();
        adminSignature1.setInputLabel("Admin signature");
        adminSignature1.setInputType("signature");
        adminSignature1.setIsRequired(true);

        Question approverSignature1 = new Question();
        approverSignature1.setInputLabel("Approver signature");
        approverSignature1.setInputType("signature");
        approverSignature1.setIsRequired(true);

        Question effectiveDateQn = new Question();
        effectiveDateQn.setInputLabel("Effective Date:");
        effectiveDateQn.setInputType("Date");
        effectiveDateQn.setIsRequired(true);

        questionRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5,q6,q7,q7a,q8,q9,q9a,q10,q10a,adminSignature1,approverSignature1));

        // set new Form
        Form newVendorAssessmentForm = new Form();
        newVendorAssessmentForm.setFormName("New Vendor Assessment Form");

        Long millis = System.currentTimeMillis();
        java.sql.Date formDate = new java.sql.Date(millis);
        newVendorAssessmentForm.setDateSubmitted(formDate);
        newVendorAssessmentForm.setLastEdited(formDate);

        formRepository.save(newVendorAssessmentForm);

        Question[] questionSet1 = {q1,q2,q3,q4,q5,q6,q7,q7a,q8};

        // create Section 1: General Information about the vendor company
        setupSection(
                "General Information",
                "General Information about the vendor company",
                newVendorAssessmentForm,
                questionSet1,
                UserTypes.VENDOR
        );


        // create Section 2: Vendor Evaluation (to be filled by Quantum Leap)
        Question[] questionSet2 = {q9, q9a, q10, adminSignature1};

        setupSection(
                "Admin Evaluation",
                "Vendor Evaluation (to be filled by Quantum Leap Admin)",
                newVendorAssessmentForm,
                questionSet2,
                UserTypes.ADMIN
        );

        Question[] questionSet3 ={approverSignature1, effectiveDateQn};

        setupSection(
                "Approver Evaluation",
                "Vendor Evaluation (to be filled by Quantum Leap Approver)",
                newVendorAssessmentForm,
                questionSet3,
                UserTypes.APPROVER
        );

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
        f2q8.setInputLabel("Are regular tool-box meetings conducted and reports submitted?");
        addYesNoRadio(f2q8);
        f2q8.setIsRequired(true);

        Question f2q9 = new Question();
        f2q9.setInputLabel("Are relevant safety training courses provided for management/Supervisors?");
        addYesNoRadio(f2q9);
        f2q9.setIsRequired(true);

        Question f2q10 = new Question();
        f2q10.setInputLabel("Are relevant safety training courses provided for workers?");
        addYesNoRadio(f2q10);
        f2q10.setIsRequired(true);

        Question f2q11 = new Question();
        f2q11.setInputLabel("Are relevant safety training certificates submitted?");
        addYesNoRadio(f2q11);
        f2q11.setIsRequired(true);

        Question f2q12 = new Question();
        f2q12.setInputLabel("Are there written safety & health rules for the workers?");
        addYesNoRadio(f2q12);
        f2q12.setIsRequired(true);

        Question f2q13 = new Question();
        f2q13.setInputLabel("Are there written safe work procedures/ risk assessment formulated and submitted?");
        addYesNoRadio(f2q13);
        f2q13.setIsRequired(true);

        Question f2q14 = new Question();
        f2q14.setInputLabel("Is there a written programme outlining inspection guidelines, frequency and follow-up corrective actions?");
        addYesNoRadio(f2q14);
        f2q14.setIsRequired(true);

        Question f2q15 = new Question();
        f2q15.setInputLabel("Is there available Personal Protective Equipment and of proper working condition and comply to safety requirements?");
        addYesNoRadio(f2q15);
        f2q15.setIsRequired(true);

        Question f2q16 = new Question();
        f2q16.setInputLabel("Is there a Safety Supervisor working at least 5 hrs / week?");
        addYesNoRadio(f2q16);
        f2q16.setIsRequired(true);

        Question f2q17 = new Question();
        f2q17.setInputLabel("Is there a qualified First Aider?");
        addYesNoRadio(f2q17);
        f2q17.setIsRequired(true);

        Question f2q18 = new Question();
        f2q18.setInputLabel("Are there relevant Licensed Electrical Workers, qualified engineers, qualified supervisors, lifting supervisors, qualified JCB Tower/Mobile/Crawler Crane operators?");
        addYesNoRadio(f2q18);
        f2q18.setIsRequired(true);

        Question f2q19 = new Question();
        f2q19.setInputLabel("Number of Temporary Disability Cases");
        f2q19.setInputType("number");
        f2q19.setIsRequired(true);

        Question f2q20 = new Question();
        f2q20.setInputLabel("Number of Permanent Disability Cases");
        f2q20.setInputType("number");
        f2q20.setIsRequired(true);

        Question f2q21 = new Question();
        f2q21.setInputLabel("Number of Fatal Cases");
        f2q21.setInputType("number");
        f2q21.setIsRequired(true);

        questionRepository.saveAll(Arrays.asList(f2q1,f2q2,f2q3,f2q4,f2q5,f2q6,f2q7,f2q8,f2q9, f2q10, f2q11, f2q12, f2q13, f2q14, f2q15, f2q16, f2q17, f2q18, f2q19, f2q20, f2q21));

        Form subcontractorSafetyHealthEvaluationForm = new Form();
        subcontractorSafetyHealthEvaluationForm.setFormName("Subcontractor's Safety & Health Pre-Evaluation");

        subcontractorSafetyHealthEvaluationForm.setDateSubmitted(formDate);
        subcontractorSafetyHealthEvaluationForm.setLastEdited(formDate);

        // create Section 1: Safety & Health Policy and Organisation
        Question[] questionSet2a = {f2q1,f2q2,f2q3,f2q4};

        setupSection(
                "General Information",
                "",
                subcontractorSafetyHealthEvaluationForm,
                questionSet2a,
                UserTypes.VENDOR
        );

        // create Section 1: Safety & Health Policy and Organisation
        Question[] questionSet4 = {f2q5,f2q6,f2q7};

        setupSection(
                "Safety & Health Policy and Organisation",
                "",
                subcontractorSafetyHealthEvaluationForm,
                questionSet4,
                UserTypes.VENDOR
        );

        formRepository.save(subcontractorSafetyHealthEvaluationForm);

        Question[] questionSet5 = {f2q8};

        setupSection(
                "Tool Box Meeting",
                "",
                subcontractorSafetyHealthEvaluationForm,
                questionSet5,
                UserTypes.VENDOR
        );

        formRepository.save(subcontractorSafetyHealthEvaluationForm);

        Question[] questionSet6 = {f2q9,f2q10,f2q11};

        setupSection(
                "Safety Training",
                "",
                subcontractorSafetyHealthEvaluationForm,
                questionSet6,
                UserTypes.VENDOR
        );

        formRepository.save(subcontractorSafetyHealthEvaluationForm);

        Question[] questionSet7= {f2q12,f2q13};

        setupSection(
                "Safety & Health Rules & Safe Work Procedures/ Risk Assessment",
                "",
                subcontractorSafetyHealthEvaluationForm,
                questionSet7,
                UserTypes.VENDOR
        );

        formRepository.save(subcontractorSafetyHealthEvaluationForm);

        Question[] questionSet8 = {f2q14, f2q15};

        setupSection(
                "Safety & Health Inspection & Equipment",
                "",
                subcontractorSafetyHealthEvaluationForm,
                questionSet8,
                UserTypes.VENDOR
        );

        formRepository.save(subcontractorSafetyHealthEvaluationForm);

        Question[] questionSet9 = {f2q16, f2q17, f2q18};

        setupSection(
                "Responsible Personnel",
                "",
                subcontractorSafetyHealthEvaluationForm,
                questionSet9,
                UserTypes.VENDOR
        );

        formRepository.save(subcontractorSafetyHealthEvaluationForm);

        Question[] questionSet10 = {f2q19, f2q20, f2q21};

        setupSection(
                "Accident Analysis",
                "",
                subcontractorSafetyHealthEvaluationForm,
                questionSet10,
                UserTypes.VENDOR
        );

        formRepository.save(subcontractorSafetyHealthEvaluationForm);

        // -------------- f05

        Form form_f05 = new Form();
        form_f05.setFormName("Subcontractor's Safety & Health Pre-Evaluation");

        form_f05.setDateSubmitted(formDate);
        form_f05.setLastEdited(formDate);

        Question f5q1 = new Question();
        f5q1.setInputLabel("Name of Subcontractor");
        f5q1.setInputType("text");
        f5q1.setIsRequired(true);

        Question f5q2 = new Question();
        f5q2.setInputLabel("Trade");
        f5q2.setInputType("text");
        f5q2.setIsRequired(true);

        Question f5q3 = new Question();
        f5q3.setInputLabel("Project / Worksite");
        f5q3.setInputType("text");
        f5q3.setIsRequired(true);

        Question f5q4 = new Question();
        f5q4.setInputLabel("Date of Evaluation");
        f5q4.setInputType("Date");

        // section on general information
        Question[] f5section1 = {f5q1,f5q2,f5q3,f5q4};

        setupSection(
                "General Information",
                "",
                form_f05,
                f5section1,
                UserTypes.VENDOR
        );

        formRepository.save(form_f05);

        // Participation in safety

        Question f5q5 = new Question();
        f5q5.setInputLabel("Attendance in Safety Meeting");
        add1To5Checkbox(f5q5);
        f5q5.setIsRequired(true);

        Question f5q6 = new Question();
        f5q6.setInputLabel("Toolbox Meeting");
        add1To5Checkbox(f5q6);
        f5q6.setIsRequired(true);

        Question f5q7 = new Question();
        f5q7.setInputLabel("Compliance to Rules & Regulation");
        add1To5Checkbox(f5q7);
        f5q7.setIsRequired(true);

        Question f5q8 = new Question();
        f5q8.setInputLabel("Safety Promotional Activities");
        add1To5Checkbox(f5q8);
        f5q8.setIsRequired(true);

        Question f5q9 = new Question();
        f5q9.setInputLabel("Document Submission");
        add1To5Checkbox(f5q9);
        f5q9.setIsRequired(true);

        Question f5q10 = new Question();
        f5q10.setInputLabel("Participation Safety Score");
        f5q10.setInputType("number");
        f5q10.setIsRequired(true);

        Question[] f5section2 = {f5q5,f5q6,f5q7,f5q8,f5q9,f5q10};

        setupSection(
                "Part I: Participation In Safety",
                "Participation In Safety",
                form_f05,
                f5section2,
                UserTypes.VENDOR
        );

        formRepository.save(form_f05);

        // Part II: safety training and competencies
        Question f5q11 = new Question();
        f5q11.setInputLabel("Statutory Safety Training Course");
        add1To5Checkbox(f5q11);
        f5q11.setIsRequired(true);

        Question f5q12 = new Question();
        f5q12.setInputLabel("Safety trade Course");
        add1To5Checkbox(f5q12);
        f5q12.setIsRequired(true);

        Question f5q13 = new Question();
        f5q13.setInputLabel("Mass Safety Walk");
        add1To5Checkbox(f5q13);
        f5q13.setIsRequired(true);

        Question f5q14 = new Question();
        f5q14.setInputLabel("WSH Safety Coordinator / Supervisor");
        add1To5Checkbox(f5q14);
        f5q14.setIsRequired(true);

        Question f5q15 = new Question();
        f5q15.setInputLabel("Other Safety Training");
        add1To5Checkbox(f5q15);
        f5q15.setIsRequired(true);

        Question f5q16 = new Question();
        f5q16.setInputLabel("Safety Training and Competencies Score");
        f5q16.setInputType("number");
        f5q16.setIsRequired(true);

        Question[] f5section3 = {f5q11,f5q12,f5q13,f5q14,f5q15,f5q16};

        setupSection(
                "Part II: Safety Training and Competencies (Percentage of Attendance)",
                "Safety Training and Competencies",
                form_f05,
                f5section3,
                UserTypes.VENDOR
        );

        formRepository.save(form_f05);


        // Part III: Accident / Incident Preview

        Question f5q17 = new Question();
        f5q17.setInputLabel("Effort in Accident Prevention");
        add1To5Checkbox(f5q17);
        f5q17.setIsRequired(true);

        Question f5q18 = new Question();
        f5q18.setInputLabel("Safety Work Practice / Permit to Work");
        add1To5Checkbox(f5q18);
        f5q18.setIsRequired(true);

        Question f5q19 = new Question();
        f5q19.setInputLabel("Incident Severity & Frequency Rate");
        add1To5Checkbox(f5q19);
        f5q19.setIsRequired(true);

        Question f5q20 = new Question();
        f5q20.setInputLabel("Safety Offence");
        add1To5Checkbox(f5q20);
        f5q20.setIsRequired(true);

        Question f5q21 = new Question();
        f5q21.setInputLabel("Safety Inspection And Rectification");
        add1To5Checkbox(f5q21);
        f5q21.setIsRequired(true);

        Question f5q22 = new Question();
        f5q22.setInputLabel("Accident / Incident Preview Score");
        f5q22.setInputType("number");
        f5q22.setIsRequired(true);

        Question[] f5section4 = {f5q17,f5q18,f5q19,f5q20,f5q21,f5q22};

        setupSection(
                "Part III: Accident / Incident Preview",
                "Accident / Incident Preview",
                form_f05,
                f5section4,
                UserTypes.VENDOR
        );

        formRepository.save(form_f05);

        // Part IV: Maintenance of Equipment
        Question f5q23 = new Question();
        f5q23.setInputLabel("Explosive Powered Tool / Cutting Tool");
        add1To5Checkbox(f5q23);
        f5q23.setIsRequired(true);

        Question f5q24 = new Question();
        f5q24.setInputLabel("Ladder");
        add1To5Checkbox(f5q24);
        f5q24.setIsRequired(true);

        Question f5q25 = new Question();
        f5q25.setInputLabel("Lifting Gear / Appliance / Machine");
        add1To5Checkbox(f5q25);
        f5q25.setIsRequired(true);

        Question f5q26 = new Question();
        f5q26.setInputLabel("Electrical Equipment / Compressor");
        add1To5Checkbox(f5q26);
        f5q26.setIsRequired(true);

        Question f5q27 = new Question();
        f5q27.setInputLabel("Other Machineries");
        add1To5Checkbox(f5q27);
        f5q27.setIsRequired(true);

        Question f5q28 = new Question();
        f5q28.setInputLabel("Maintenance of Equipment Score");
        f5q28.setInputType("number");
        f5q28.setIsRequired(true);

        Question[] f5section5 = {f5q23,f5q24,f5q25,f5q26,f5q27,f5q28};

        setupSection(
                "Part IV: Maintenance of Equipment",
                "Maintenance of Equipment",
                form_f05,
                f5section5,
                UserTypes.VENDOR
        );

        formRepository.save(form_f05);

        // Part V: General Housekeeping and Others
        Question f5q29 = new Question();
        f5q29.setInputLabel("Subcon Snr. Mgmt Commitment to HS");
        add1To5Checkbox(f5q29);
        f5q29.setIsRequired(true);

        Question f5q30 = new Question();
        f5q30.setInputLabel("Compliance with PPE");
        add1To5Checkbox(f5q30);
        f5q30.setIsRequired(true);

        Question f5q31 = new Question();
        f5q31.setInputLabel("Housekeeping & Cleanliness at Site");
        add1To5Checkbox(f5q31);
        f5q31.setIsRequired(true);

        Question f5q32 = new Question();
        f5q32.setInputLabel("Housekeeping & Cleanliness at Store");
        add1To5Checkbox(f5q32);
        f5q32.setIsRequired(true);

        Question f5q33 = new Question();
        f5q33.setInputLabel("Housekeeping & Cleanliness at Quarter");
        add1To5Checkbox(f5q33);
        f5q33.setIsRequired(true);

        Question f5q34 = new Question();
        f5q34.setInputLabel("General Housekeeping and Others Score");
        f5q34.setInputType("number");
        f5q34.setIsRequired(true);

        Question[] f5section6 = {f5q29,f5q30,f5q31,f5q32,f5q33,f5q34};

        setupSection(
                "Part V: General Housekeeping and Others",
                "General Housekeeping and Others",
                form_f05,
                f5section6,
                UserTypes.VENDOR
        );

        formRepository.save(form_f05);


        // Total Score
        Question f5q35 = new Question();
        f5q35.setInputLabel("Total Score");
        f5q35.setInputType("number");
        f5q35.setIsRequired(true);

        // overall performance standard
        Question f5q36 = new Question();
        addPerformanceStandard(f5q36);
        f5q36.setIsRequired(true);

        // comments
        Question f5q37 = new Question();
        f5q37.setInputLabel("Comments");
        f5q37.setInputType("text");

        Question[] f5section7 = {f5q35,f5q36,f5q37};

        setupSection(
                "Total Score",
                "Total Score",
                form_f05,
                f5section7,
                UserTypes.VENDOR
        );

        formRepository.save(form_f05);

        // Evaluation by Admin

        Question safetyCoordinatorName = new Question();
        safetyCoordinatorName.setInputLabel("Safety Coordinator");
        safetyCoordinatorName.setInputType("text");
        safetyCoordinatorName.setIsRequired(true);

        Question safetyCoordinatorSignature = new Question();
        safetyCoordinatorSignature.setInputLabel("Safety Coordinator Signature");
        safetyCoordinatorSignature.setInputType("signature");
        safetyCoordinatorName.setIsRequired(true);

        Question safetyCoordinatorDate = new Question();
        safetyCoordinatorDate.setInputLabel("Safety Coordinator Date");
        safetyCoordinatorDate.setInputType("Date");
        safetyCoordinatorName.setIsRequired(true);

        Question[] evaluatorSection = {safetyCoordinatorName,safetyCoordinatorSignature,safetyCoordinatorDate};

        setupSection(
                "Evaluation by Admin",
                "Evaluation by Admin",
                form_f05,
                evaluatorSection,
                UserTypes.ADMIN
        );

        formRepository.save(form_f05);

        // Evaluation by Approver

        Question directorName = new Question();
        directorName.setInputLabel("Director Name");
        directorName.setInputType("text");
        directorName.setIsRequired(true);

        Question directorSignature = new Question();
        directorSignature.setInputLabel("Director Signature");
        directorSignature.setInputType("signature");
        directorSignature.setIsRequired(true);

        Question directorDate = new Question();
        directorDate.setInputLabel("Director Date");
        directorDate.setInputType("Date");
        directorDate.setIsRequired(true);

        Question[] approverSection = {directorName,directorSignature,directorDate};

        setupSection(
                "Evaluation by Approver",
                "Evaluation by Approver",
                form_f05,
                approverSection,
                UserTypes.APPROVER
        );

        formRepository.save(form_f05);




        // ------------------------------- Create Vendors -------------------------------
        Vendor vendor1 = new Vendor();
        vendor1.setUserName("Vendor1");
        vendor1.setEmailAddress("dracomalfoycl8@gmail.com");
        vendor1.setPassword("123456");
        vendor1.setCompanyName("Vendor1 Company");
        vendor1.setOfficeAddress("Vendor1 Office Address");
        vendor1.setOfficeTel("12345678");
        vendor1.setOfficeFax("12345678");
        vendor1.setRegistrationNo(1233456L);
        vendor1.setBusinessType("Vendor1 Business Type");

        Vendor vendor2 = new Vendor();
        vendor2.setEvaluationId("123");
        vendor2.setUserName("Vendor2");
        vendor2.setEmailAddress("isalsamudra@gmail.com");
        vendor2.setPassword("123456");
        vendor2.setCompanyName("Vendor2 Company");
        vendor2.setOfficeAddress("Vendor2 Office Address");
        vendor2.setOfficeTel("12345678");
        vendor2.setOfficeFax("12345678");
        vendor2.setRegistrationNo(1233456L);
        vendor2.setBusinessType("Vendor2 Business Type");

        Vendor vendor3 = new Vendor();
        vendor3.setEvaluationId("123");
        vendor3.setUserName("Vendor3");
        vendor3.setEmailAddress("vendor.3@gmail.com");
        vendor3.setPassword("123456");
        vendor3.setCompanyName("Vendor3 Company");
        vendor3.setOfficeAddress("Vendor3 Office Address");
        vendor3.setOfficeTel("12345678");
        vendor3.setOfficeFax("12345678");
        vendor3.setRegistrationNo(1233456L);
        vendor3.setBusinessType("Vendor3 Business Type");
        vendor3.setEvaluationId("123");


        // ------------------------------- Create Admins ------------------------------
        Admin admin1 = new Admin();
        admin1.setUserName("Admin1");
        admin1.setEmailAddress("wejustclimb@gmail.com");
        admin1.setPassword("123456");

        Admin admin2 = new Admin();
        admin2.setUserName("Admin2");
        admin2.setEmailAddress("isalsamudra@gmail.com");
        admin2.setPassword("123456");


        // ------------------------------- Create Approver ------------------------------
        Approver approver1 = new Approver();
        approver1.setUserName("Approver1");
        approver1.setEmailAddress("lancelimzuyong9@gmail.com");
        approver1.setPassword("123456");


        // ------------------------------- Save Users to DB ------------------------------
        userRepository.saveAll(Arrays.asList(vendor1, vendor2, vendor3, admin1, admin2, approver1));


        // -------------------------------- WorkFlow ----------------------

        WorkFlow workFlow1 = new WorkFlow();
        workFlow1.setWfName("workflow1");
        workFlow1.setWfDateline(new Date(2020,1,1));
        workFlow1.setWfLastSubmit(new Date(2020,1,1));
        workFlow1.setWorkFlowStatus(IS442_Quantum.backend.Enums.WorkFlowStatus.IN_PROGRESS);
        workFlow1.setVendor(vendor1);
        workFlow1.setAdmin(admin1);
        workFlow1.setApprover(approver1);

        WorkFlow workFlow2 = new WorkFlow();
        workFlow2.setWfName("workflow2");
        workFlow2.setWfDateline(new Date(2020,1,1));
        workFlow2.setWfLastSubmit(new Date(2020,1,1));
        workFlow2.setWorkFlowStatus(IS442_Quantum.backend.Enums.WorkFlowStatus.IN_PROGRESS);
        workFlow2.setVendor(vendor2);
        workFlow2.setAdmin(admin2);
        workFlow2.setApprover(approver1);

        workFlowRepository.saveAll(Arrays.asList(workFlow1, workFlow2));

        // ------------------------------- Create Form Sequence -------------------------------
        ArrayList<FormSequence> fs1List = new ArrayList<FormSequence>();
        FormSequence fs1 = new FormSequence();
        fs1.setForm(subcontractorSafetyHealthEvaluationForm);
        fs1.setSeqNo(1);
        fs1.setStatus(FormSequenceStatus.PENDING);
        fs1.setWorkFlow(workFlow1);
        fs1List.add(fs1);

        ArrayList<FormSequence> fs2List = new ArrayList<FormSequence>();
        FormSequence fs2 = new FormSequence();
        fs2.setForm(subcontractorSafetyHealthEvaluationForm);
        fs2.setSeqNo(2);
        fs2.setStatus(FormSequenceStatus.REQUESTED);
        fs2.setWorkFlow(workFlow2);
        fs2List.add(fs2);

        formSequenceRepository.saveAll(Arrays.asList(fs1, fs2));
    }

    public void addYesNoRadio(Question q){
        q.setInputType("Radio");
        q.addList(new QuestionProperty(("Yes")));
        q.addList(new QuestionProperty(("No")));

    }

    public void add1To5Checkbox(Question q) {
        q.setInputType("Radio");
        q.addList(new QuestionProperty("1 Poor"));
        q.addList(new QuestionProperty("2 Below Average"));
        q.addList(new QuestionProperty("3 Average"));
        q.addList(new QuestionProperty("4 Above Average"));
        q.addList(new QuestionProperty("5 Good"));
    }

    public void addPerformanceStandard(Question q) {
        q.setInputType("Radio");
        q.addList(new QuestionProperty("Poor"));
        q.addList(new QuestionProperty("Below Average"));
        q.addList(new QuestionProperty("Average"));
        q.addList(new QuestionProperty("Above Average"));
        q.addList(new QuestionProperty("Good"));
    }

    public void setupSection(String title, String description, Form form, Question[] questions, UserTypes usertype){
        Section newSection = new Section();
        newSection.setTitle(title);
        newSection.setDescription(description);
        newSection.setForm(form);
        newSection.setUserType(usertype);

        for (Question q : questions){
            newSection.getQuestions().add(q);
            q.setSection(newSection);
        }

        form.getSections().add(newSection);
    }

}
