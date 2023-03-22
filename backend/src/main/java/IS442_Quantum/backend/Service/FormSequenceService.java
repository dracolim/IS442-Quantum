package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.FormSequence;
import IS442_Quantum.backend.Repository.FormSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FormSequenceService {

    @Autowired
    private FormSequenceRepository formSequenceRepository;
    public Collection<FormSequence> getAll(){
        return formSequenceRepository.findAll();
    }

    public  void deleteFormSequenceByID(Long id){ formSequenceRepository.deleteById(id);}

    public Optional<FormSequence> getFormSequenceByID(Long id){return formSequenceRepository.findById(id);}

    public boolean checkFormSequence(Long id){return formSequenceRepository.existsById(id);}
}
