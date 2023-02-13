package IS442_Quantum.backend.Controller;


import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public Iterable<Question>getAllQuestionnaires() {
        return questionService.getAllQuestionnaires();
    }

    @GetMapping("/question/{id}")
    public Question findByInputId(@PathVariable Long id){
        return questionService.findByQuestionnaireId(id);
    }

    @PostMapping(value = "/question")
    public Question newInputProperties(@RequestBody Question newQuestion){
        return questionService.createNewQuestionnaires(newQuestion);
    }
}
