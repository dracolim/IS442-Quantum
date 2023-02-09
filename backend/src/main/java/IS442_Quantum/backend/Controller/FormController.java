package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Repository.FormRepository;
import IS442_Quantum.backend.Service.FormService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Data
public class FormController {

    @Autowired
    private final FormService formService;

    @Autowired
    private final FormRepository formRepository;

    @GetMapping("/forms")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(formService.getAllForm(), HttpStatus.OK);
    }

    @GetMapping("/form/{id}")
    public Optional<Form>getForm(@PathVariable Long id){
        return formRepository.findById(id);
    }

    @PostMapping(value = "/form")
    public ResponseEntity<?> newForm(@RequestBody Form newForm){
        return new ResponseEntity<>(formService.createNewForm(newForm), HttpStatus.CREATED);
    }

}
