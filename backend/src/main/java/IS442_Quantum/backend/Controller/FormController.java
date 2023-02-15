package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Service.FormService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@Data
public class FormController {

    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("/forms")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(formService.getAllForm(), HttpStatus.OK);
    }

    @GetMapping("/form/{id}")
    public ResponseEntity<?>getForm(@PathVariable Long id){
        return new ResponseEntity<>(formService.getFormById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/form")
    public ResponseEntity<?> newForm(@RequestBody Form newForm){
        return new ResponseEntity<>(formService.createNewForm(newForm), HttpStatus.CREATED);
    }

    @DeleteMapping("/form/{id}")
    public ResponseEntity<?> deleteFormById(@PathVariable Long id){
        if(id == 0 || id == null || !formService.checkFormById(id)){
            return new ResponseEntity<>("Delete failed, please provide a valid form ID", HttpStatus.BAD_REQUEST);
        } else {
            Optional<Form> tempForm = formService.getFormById(id);
            formService.deleteFormById(id);
            return new ResponseEntity<>(tempForm, HttpStatus.OK);
        }
    }

}
