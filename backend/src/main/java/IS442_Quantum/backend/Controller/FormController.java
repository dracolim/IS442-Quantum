package IS442_Quantum.backend.Controller;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Repository.FormRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class FormController {

    private final FormRepository formRepository;

    public FormController(FormRepository formRepository){
        this.formRepository = formRepository;
    }

    @GetMapping("/forms")
    public Iterable<Form>getAll() {
        return formRepository.findAll();
    }

    @GetMapping("/form/{id}")
    public Optional<Form>getForm(@PathVariable Long id){
        return formRepository.findById(id);
    }

}
