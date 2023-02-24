package IS442_Quantum.backend.Controller;


import IS442_Quantum.backend.Model.Question;
import IS442_Quantum.backend.Service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@CrossOrigin
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public ResponseEntity<?> getAllQuestionnaires() {
        return new ResponseEntity<>(questionService.getAllQuestion(), HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<?> findByInputId(@PathVariable Long id){
        return new ResponseEntity<>(questionService.findByQuestion(id), HttpStatus.OK);
    }

    @PostMapping(value = "/question")
    public ResponseEntity<?> newInputProperties(@RequestBody Question newQuestion){
        if (newQuestion != null &&
            newQuestion.getInputLabel()!= null  &&
            newQuestion.getInputType() != null &&
            newQuestion.getIsRequired() != null
        ){
            return new ResponseEntity<>(questionService.createNewQuestion(newQuestion), HttpStatus.OK);
        }
        return new ResponseEntity<>("creation failed", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable Long id){
        if(id == 0 || !questionService.checkQuestionById(id)){
            return new ResponseEntity<>("Delete failed, please provide a valid question ID", HttpStatus.NOT_FOUND);
        } else {
            Question tempQn = questionService.findByQuestion(id);
            questionService.deleteQuestionById(id);
            return new ResponseEntity<>(tempQn, HttpStatus.OK);
        }
    }

    @PutMapping("/question/{id}")
    public ResponseEntity<?> editQuestionById(@RequestBody Question newQuestion, @PathVariable Long id){
        if(questionService.checkQuestionById(id) || id != null){
            return new ResponseEntity<>(questionService.editQuestionById(id, newQuestion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Edit failed, please provide a valid question and ID", HttpStatus.NOT_FOUND);
        }
    }
}
