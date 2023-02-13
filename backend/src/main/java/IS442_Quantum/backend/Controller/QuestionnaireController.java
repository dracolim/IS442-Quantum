package IS442_Quantum.backend.Controller;


import IS442_Quantum.backend.Model.Questionnaire;
import IS442_Quantum.backend.Service.QuestionnaireService;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService){
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/questionnaires")
    public Iterable<Questionnaire>getAllQuestionnaires() {
        return questionnaireService.getAllQuestionnaires();
    }

    @GetMapping("/questionnaire/{id}")
    public Questionnaire findByInputId(@PathVariable Long id){
        return questionnaireService.findByQuestionnaireId(id);
    }

    @PostMapping(value = "/questionnaire")
    public Questionnaire newInputProperties(@RequestBody Questionnaire newQuestionnaire){
        return questionnaireService.createNewQuestionnaires(newQuestionnaire);
    }
}
