package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Questionnaires;
import IS442_Quantum.backend.Repository.QuestionnairesRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionnairesService {

    private QuestionnairesRepository questionnairesRepository;

    public QuestionnairesService(QuestionnairesRepository questionnairesRepository) {
        this.questionnairesRepository = questionnairesRepository;
    }

    public Questionnaires findByQId(Long qId){
        return questionnairesRepository.findByQId(qId);
    }

    public Iterable<Questionnaires>getAllQuestionnaires(){
        return questionnairesRepository.findAll();
    }

    public Questionnaires createNewQuestionnaires(Questionnaires newQuestionnaires){
        return questionnairesRepository.save(newQuestionnaires);
    }

}
