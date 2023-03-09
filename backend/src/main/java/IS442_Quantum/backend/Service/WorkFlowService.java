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
            newFormSequence.setStatus(fs.getStatus());
            formSequences.add(newFormSequence);
        }
        newWorkFlow.setFormSequences(formSequences);
        return workFlowRepository.save(newWorkFlow);
    }

    public void deleteWorkFlowById(long id ){
        workFlowRepository.deleteById(id);
    }

    public boolean checkWorkFlowById(long id){
        return workFlowRepository.existsById(id);
    }

    public Optional<WorkFlow> getWorkFlowById(long id){
        return workFlowRepository.findById(id);
    }

    public WorkFlow updateWorkFlowById(Long id,WorkFlow newWorkFlow){
        // id = wf_id
        System.out.println("updatedWorkflow: " + newWorkFlow);
        System.out.println("updated Form sequence: " + newWorkFlow.getFormSequences());
        Optional<WorkFlow> optionalWorkFlow = workFlowRepository.findById(id);
        System.out.println(checkWorkFlowById(id));
        if(checkWorkFlowById(id)) {
            WorkFlow eWorkFlow = optionalWorkFlow.get();
            System.out.println("Existing workflow form sequence: " + eWorkFlow.getFormSequences());
            
            eWorkFlow.setWfName(newWorkFlow.getWfName());
            eWorkFlow.setValidated(newWorkFlow.isValidated());
            eWorkFlow.setWfDateline(newWorkFlow.getWfDateline());
            eWorkFlow.setWfLastSubmit(newWorkFlow.getWfLastSubmit());
            eWorkFlow.getFormSequences().clear();

            Collection<FormSequence> formSequences = new ArrayList<>();

            for (FormSequence fs : newWorkFlow.getFormSequences()) {
                FormSequence newFormSequence = new FormSequence();
                newFormSequence.setWorkFlow(eWorkFlow);
                newFormSequence.setForm(formService.getFormById(fs.getForm().getFormId()));
                newFormSequence.setStatus(fs.getStatus());
                formSequences.add(newFormSequence);
            }
            eWorkFlow.setFormSequences(formSequences);
            return workFlowRepository.save(eWorkFlow);
        }else {
            return null;
        }
    }

}
