package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.FormSequence;
import IS442_Quantum.backend.Model.WorkFlow;
import IS442_Quantum.backend.Repository.FormRepository;
import IS442_Quantum.backend.Repository.WorkFlowRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.DelegatingToExoticInstantiator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class WorkFlowService {

    @Autowired
    private WorkFlowRepository workFlowRepository;

    @Autowired
    private FormService formService;

    public WorkFlow createWorkFlow(WorkFlow workFlow){
        WorkFlow newWorkFlow = new WorkFlow();
        newWorkFlow.setValidated(workFlow.isValidated());
        newWorkFlow.setWfName(workFlow.getWfName());
        newWorkFlow.setWfDateline(workFlow.getWfDateline());
        newWorkFlow.setWfLastSubmit(workFlow.getWfLastSubmit());
        Collection<FormSequence> formSequences = new ArrayList<>();
        for(FormSequence fs : workFlow.getFormSequences()){
            FormSequence newFormSequence = new FormSequence();
            newFormSequence.setWorkFlow(newWorkFlow);
            newFormSequence.setForm(formService.getFormById(fs.getForm().getFormId()));
            newFormSequence.setApproved(fs.isApproved());
            formSequences.add(newFormSequence);
        }
        newWorkFlow.setFormSequences(formSequences);
        return workFlowRepository.save(newWorkFlow);
    }

    public void deleteWorkFlowById(long id ){
        workFlowRepository.deleteById(id);
    }

    public boolean checkWorkFlowById(Long id){
        return workFlowRepository.existsById(id);
    }

    public Optional<WorkFlow> getWorkFlowById(Long id){
        return workFlowRepository.findById(id);
    }

    public WorkFlow updateWorkFlow(Long id,WorkFlow workFlow){
        if(checkWorkFlowById(id)){
            return workFlowRepository.save(workFlow);
        }else {return workFlow;}


    }


}
