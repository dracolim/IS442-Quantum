package IS442_Quantum.backend.Controller;


import IS442_Quantum.backend.Model.Questionnaires;
import IS442_Quantum.backend.Repository.QuestionnairesRepository;
import IS442_Quantum.backend.Service.QuestionnairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionnairesController {

    private final QuestionnairesService questionnairesService;

    public QuestionnairesController(QuestionnairesService questionnairesService){
        this.questionnairesService = questionnairesService;
    }

    @GetMapping("/questionnaires")
    public Iterable<Questionnaires>getAllQuestionnaires() {
        return questionnairesService.getAllQuestionnaires();
    }

    @GetMapping("/questionnaires/{id}")
    public Questionnaires findByInputId(@PathVariable Long id){
        return questionnairesService.findByQId(id);
    }

    @PostMapping(value = "/questionnaires")
    public Questionnaires newInputProperties(@RequestBody Questionnaires newQuestionnaires){
        return questionnairesService.createNewQuestionnaires(newQuestionnaires);
    }
}
