package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.WorkFlow;
import IS442_Quantum.backend.Repository.WorkFlowRepository;
import IS442_Quantum.backend.Service.FormService;
import IS442_Quantum.backend.Service.WorkFlowService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Data
public class WorkFlowController {

    @Autowired
    private final WorkFlowRepository workFlowRepository;

    @Autowired
    private final WorkFlowService workFlowService;

    @GetMapping("/workflows")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(workFlowService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/workflow/{id}")
    public Optional<WorkFlow> getForm(@PathVariable Long id){
        return workFlowRepository.findById(id);
    }





}
