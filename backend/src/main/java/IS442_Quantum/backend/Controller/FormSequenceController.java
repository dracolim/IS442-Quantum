package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Model.FormSequence;
import IS442_Quantum.backend.Model.WorkFlow;
import IS442_Quantum.backend.Service.FormSequenceService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin
@Data
public class FormSequenceController {
    @Autowired
    private final FormSequenceService formSequenceService;
    @DeleteMapping("/formsequences/{id}")
    public ResponseEntity<?> deleteFormSequenceById(@PathVariable Long id){
        if(id == 0 || id == null || !formSequenceService.checkFormSequence(id)){
            return new ResponseEntity<>("Delete failed, please provide a valid form sequence ID", HttpStatus.BAD_REQUEST);
        } else {
            Optional<FormSequence> tempFormSequence = formSequenceService.getFormSequenceByID(id);
            formSequenceService.deleteFormSequenceByID(id);
            return new ResponseEntity<>(tempFormSequence, HttpStatus.OK);
        }
    }


}
