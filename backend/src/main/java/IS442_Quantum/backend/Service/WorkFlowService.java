package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.*;
import IS442_Quantum.backend.Repository.WorkFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    public WorkFlow createWorkFlow(WorkFlow workFlow){
        WorkFlow newWorkFlow = new WorkFlow();
        newWorkFlow.setValidated(workFlow.isValidated());
        newWorkFlow.setWfName(workFlow.getWfName());
        newWorkFlow.setWfDateline(workFlow.getWfDateline());
        newWorkFlow.setWfLastSubmit(workFlow.getWfLastSubmit());
        newWorkFlow.setAdmin(workFlow.getAdmin());
        newWorkFlow.setVendor(null);
        newWorkFlow.setApprover(null);

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

            // update admin, vendor, approver
            if(newWorkFlow.getAdmin() != null){
                Optional optionalUser = userService.findUserById(newWorkFlow.getAdmin().getUserId());
                Admin admin = (Admin)optionalUser.get();
                eWorkFlow.setAdmin(admin);
            }

            // this chunk of code will set the vendor
            if(newWorkFlow.getApprover() != null){
                Optional optionalUser = userService.findUserById(newWorkFlow.getApprover().getUserId());
                Approver approver = (Approver)optionalUser.get();
                eWorkFlow.setApprover(approver);
            }

            // this chunk of code will set the vendor
            if(newWorkFlow.getVendor() != null){
                Optional optionalUser = userService.findUserById(newWorkFlow.getVendor().getUserId());
                Vendor vendor = (Vendor)optionalUser.get();
                eWorkFlow.setVendor(vendor);
            }

            // this chunk of code will set the vendor
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
