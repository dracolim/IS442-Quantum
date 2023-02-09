package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.InputProperties;
import IS442_Quantum.backend.Repository.InputPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputPropertiesService {

    @Autowired
    private InputPropertiesRepository inputPropertiesRepository;

    public InputProperties findByInputId(Long inputId){
        return inputPropertiesRepository.findByInputId(inputId);
    }

}
