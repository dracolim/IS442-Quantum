package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.FormSequence;
import IS442_Quantum.backend.Repository.FormSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FormSequenceService {

    @Autowired
    private FormSequenceRepository formSequenceRepository;



    public Collection<FormSequence> getAll(){
        return formSequenceRepository.findAll();
    }

    public FormSequence createFormSequence(){
        return FormSequence;
    }

}
