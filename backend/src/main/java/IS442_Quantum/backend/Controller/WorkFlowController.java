package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.WorkFlow;
import IS442_Quantum.backend.Repository.WorkFlowRepository;
import IS442_Quantum.backend.Service.FormService;
import IS442_Quantum.backend.Service.WorkFlowService;
import lombok.Data;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@Data
public class WorkFlowController {

    @Autowired
    private final WorkFlowRepository workFlowRepository;

    @Autowired
    private final WorkFlowService workFlowService;

    @GetMapping("/workflows")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(workFlowRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/workflows/{id}")
    public Optional<WorkFlow> getForm(@PathVariable Long id){
        return workFlowRepository.findById(id);
    }

    @PostMapping("/workflows")
    public ResponseEntity<?> newWorkFlow(@RequestBody WorkFlow newWorkFlow){
        return new ResponseEntity<>(workFlowService.createWorkFlow(newWorkFlow), HttpStatus.CREATED);
    }

    @DeleteMapping("/workflows/{id}")
    public ResponseEntity<?> deleteWorkFlowById(@PathVariable Long id){
        if(id == 0 || id == null || !workFlowService.checkWorkFlowById(id)){
            return new ResponseEntity<>("Delete failed, please provide a valid workflow ID", HttpStatus.BAD_REQUEST);
        } else {
            Optional<WorkFlow> tempWorkFlow = workFlowService.getWorkFlowById(id);
            workFlowService.deleteWorkFlowById(id);
            return new ResponseEntity<>(tempWorkFlow, HttpStatus.OK);
        }
    }
    @PutMapping("/workflows/{id}")
    public ResponseEntity<?> updateWorkflowById(@RequestBody WorkFlow newWorkFlow,@PathVariable Long id){
        return new ResponseEntity<>(workFlowService.updateWorkFlowById(id,newWorkFlow), HttpStatus.OK);
    }

    @GetMapping("/workflows/pending")
    public ResponseEntity<?> getPendingWorkFlows() {
        return new ResponseEntity<>(workFlowRepository.findPendingWorkFlow(), HttpStatus.OK);
    }
}
