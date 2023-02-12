package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.WorkFlow;
import IS442_Quantum.backend.Repository.FormRepository;
import IS442_Quantum.backend.Repository.WorkFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WorkFlowService {

    @Autowired
    private WorkFlowRepository workFlowRepository;
    public Collection<WorkFlow> getAll(){
        return workFlowRepository.findAll();
    }

}
