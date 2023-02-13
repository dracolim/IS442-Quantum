package IS442_Quantum.backend.DataLoader;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.FormQuestionnaire;
import IS442_Quantum.backend.Model.QuestionnaireList;
import IS442_Quantum.backend.Model.Questionnaire;
import IS442_Quantum.backend.Repository.FormRepository;
import IS442_Quantum.backend.Repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class FormDataLoader implements ApplicationRunner {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Override
    public void run(ApplicationArguments args) {

        Questionnaire q1 = new Questionnaire();
        q1.setInputLabel("Company's Name");
        q1.setInputType("text");
        q1.setIsRequired(true);

        Questionnaire q2 = new Questionnaire();
        q2.setInputLabel("Company Registration No");
        q2.setInputType("text");
        q2.setIsRequired(true);

        Questionnaire q3 = new Questionnaire();
        q3.setInputLabel("Office Address");
        q3.setInputType("text");
        q3.setIsRequired(true);

        Questionnaire q4 = new Questionnaire();
        q4.setInputLabel("Telephone No");
        q4.setInputType("text");
        q4.setIsRequired(true);

        Questionnaire q5 = new Questionnaire();
        q5.setInputLabel("Fax No");
        q5.setInputType("text");
        q5.setIsRequired(false);

        Questionnaire q6 = new Questionnaire();
        q6.setInputLabel("Type of Business License / Registration");
        q6.setInputType("checkbox");
        q6.setIsRequired(true);

        q6.addList(new QuestionnaireList("Sole proprietorship"));
        q6.addList(new QuestionnaireList("Limited Company"));
        q6.addList(new QuestionnaireList("Partnership Agreement"));
        q6.addList(new QuestionnaireList("Others"));

        Questionnaire q7 = new Questionnaire();
        q7.setInputLabel("Nature of Business");
        q7.setInputType("checkbox");
        q7.setIsRequired(true);

        q7.addList(new QuestionnaireList("Manufacturing"));
        q7.addList(new QuestionnaireList("Agent/dealer"));
        q7.addList(new QuestionnaireList("Distributor"));
        q7.addList(new QuestionnaireList("Others"));


        Questionnaire q7a = new Questionnaire();
        q7a.setInputLabel("Nature of Business (others)");
        q7a.setInputType("text");
        q7a.setIsRequired(false);

        Questionnaire q8 = new Questionnaire();
        q8.setInputLabel("Product / Services");
        q8.setInputType("text");
        q8.setIsRequired(false);

        Questionnaire q9 = new Questionnaire();
        q9.setInputLabel("ISO 9001 Certification");
        q9.setInputType("radio");
        q9.setIsRequired(true);
        q9.addList(new QuestionnaireList("Yes"));
        q9.addList(new QuestionnaireList("No"));



        Questionnaire q9a = new Questionnaire();
        q9a.setInputLabel("Certification Body");
        q9a.setInputType("text");
        q9a.setIsRequired(true);

        Questionnaire q10 = new Questionnaire();
        q10.setInputLabel("Accreditation of Laboratory");
        q10.setInputType("radio");
        q10.setIsRequired(true);
        q10.addList(new QuestionnaireList("Yes"));
        q10.addList(new QuestionnaireList("No"));

        Questionnaire q10a = new Questionnaire();
        q10a.setInputLabel("Accreditation Body");
        q10a.setInputType("text");
        q10a.setIsRequired(true);

        questionnaireRepository.saveAll(Arrays.asList(q1,q2,q3,q4,q5,q6,q7,q7a,q8,q9,q9a,q10,q10a));

        Form newVendorAssessmentForm = new Form();
        newVendorAssessmentForm.setFormName("New Vendor Assessment Form");

        Long millis = System.currentTimeMillis();
        java.sql.Date formDate = new java.sql.Date(millis);
        newVendorAssessmentForm.setDateSubmitted(formDate);
        newVendorAssessmentForm.setLastEdited(formDate);

        formRepository.save(newVendorAssessmentForm);

        Questionnaire[] questionnaires = {q1,q2,q3,q4,q5,q6,q7,q7a,q8,q9,q9a,q10,q10a};

        for (Questionnaire q : questionnaires){
            FormQuestionnaire newFq = new FormQuestionnaire();
            newFq.setForm(newVendorAssessmentForm);
            newFq.setQuestionnaire(q);
            newVendorAssessmentForm.addFormQuestionnaire(newFq);
        }

        formRepository.save(newVendorAssessmentForm);

    }


}
