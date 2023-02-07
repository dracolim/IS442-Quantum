package IS442_Quantum.backend.Controller;


import IS442_Quantum.backend.Model.InputProperties;
import IS442_Quantum.backend.Repository.InputPropertiesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class InputPropertiesController {

    private final InputPropertiesRepository inputPropertiesRepository;

    public InputPropertiesController(InputPropertiesRepository inputPropertiesRepository){
        this.inputPropertiesRepository = inputPropertiesRepository;
    }

    @GetMapping("/input_properties")
    public Iterable<InputProperties>getAll() {
        return inputPropertiesRepository.findAll();
    }

    @GetMapping("/input_properties/{id}")
    public Optional<InputProperties> getInputProperties(@PathVariable Long id){
        return inputPropertiesRepository.findById(id);
    }
}
