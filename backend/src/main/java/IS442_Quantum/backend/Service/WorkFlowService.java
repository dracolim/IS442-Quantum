package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Enums.FormSequenceStatus;
import IS442_Quantum.backend.Enums.WorkFlowStatus;
import IS442_Quantum.backend.Model.*;
import IS442_Quantum.backend.Repository.FormSequenceRepository;
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

    @Autowired
    private FormSequenceRepository formSequenceRepository;

    @Autowired
    private EmailNotificationService emailNotificationService;

    public WorkFlow createWorkFlow(WorkFlow workFlowBody){
        WorkFlow newWorkFlow = new WorkFlow();
        newWorkFlow.setWorkFlowStatus(IS442_Quantum.backend.Enums.WorkFlowStatus.IN_PROGRESS);
        newWorkFlow.setWfName(workFlowBody.getWfName());
        newWorkFlow.setWfDateline(workFlowBody.getWfDateline());
        newWorkFlow.setWfLastSubmit(workFlowBody.getWfLastSubmit());
        setUser(newWorkFlow, userService.findByUserId(workFlowBody.getVendor().getUserId()));
        setUser(newWorkFlow, userService.findByUserId(workFlowBody.getApprover().getUserId()));
        setUser(newWorkFlow, userService.findByUserId(workFlowBody.getAdmin().getUserId()));

        // Add formSequence
        updateFormSequence(newWorkFlow, workFlowBody);

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

    public boolean updateFormSequence(WorkFlow workFlow, WorkFlow workFlowBody){
        Collection<FormSequence> formSequences = new ArrayList<>();
        int numberOfFormSequence = 0;
        int numberOfCompletedFormSequence = 0;

        for(FormSequence fs : workFlowBody.getFormSequences()){

            FormSequence newFormSequence = fs.getFormSequenceId() == null ? new FormSequence() : formSequenceRepository.findById(fs.getFormSequenceId()).get();

            newFormSequence.setWorkFlow(workFlow);
            newFormSequence.setForm(formService.getFormById(fs.getForm().getFormId()));

            FormSequenceStatus currStatus = FormSequenceStatus.NOT_STARTED;
            FormSequenceStatus newStatus = fs.getStatus();

            // Get current form status based on FormId and seqNo
            numberOfFormSequence++;
            if (workFlow.getFormSequences()!=null){
                    for(FormSequence f : workFlow.getFormSequences()){
                    if(f.getForm().getFormId() == fs.getForm().getFormId()){
                        currStatus = f.getStatus();
                        break;
                    }
                }
            }
            if(newStatus.equals(FormSequenceStatus.APPROVED)){
                numberOfCompletedFormSequence++;
            }


            // this method update the status and trigger notification logic
            updateFormStatus(newFormSequence, fs, workFlow, currStatus, newStatus);

            formSequences.add(newFormSequence);

        }

        workFlow.setFormSequences(formSequences);


        if(numberOfFormSequence == numberOfCompletedFormSequence && numberOfFormSequence != 0){
            return true;
        }else{
            return false;
        }

    }

    // update status and trigger notification
    public void updateFormStatus(FormSequence formSequence, FormSequence formSequenceBody, WorkFlow workflow, FormSequenceStatus currStatus, FormSequenceStatus newStatus){

        // retrieve basic information
        String companyName = workflow.getVendor().getCompanyName();
        String formName = formSequence.getForm().getFormName();

        // Not Started to Pending: Vendor to Admin
        if (currStatus == FormSequenceStatus.NOT_STARTED && newStatus == FormSequenceStatus.PENDING){

            formSequence.setStatus(FormSequenceStatus.PENDING);
            String email = workflow.getAdmin().getEmailAddress();
            String emailSubject = "New Form Submission from " + email;
            String emailBody = "You have a new form submission from " + companyName + " for the following Form: " + formName;

            emailNotificationService.sendEmail(email, emailSubject, emailBody);

        // Pending to Requested: Vendor to Admin
        } else if (currStatus == FormSequenceStatus.PENDING && newStatus == FormSequenceStatus.REQUESTED){

            formSequence.setStatus(FormSequenceStatus.REQUESTED);
            String email = workflow.getVendor().getEmailAddress();
            String emailSubject = "Form requires attention [" + formName + "]";
            String emailBody = "Dear " + companyName + ", \n The following form requires attention: \n " + formName + " Kindly update the information and resubmit";

            emailNotificationService.sendEmail(email, emailSubject , emailBody);

        // Pending to Validated: Admin to Approver
        } else if (currStatus == FormSequenceStatus.PENDING && newStatus == FormSequenceStatus.VALIDATED){

            formSequence.setStatus(FormSequenceStatus.REQUESTED);
            String email = workflow.getApprover().getEmailAddress();
            String emailSubject = "Form validated [" + formName + "] please approve/reject";
            String emailBody = "Please approve/reject the following form: \n " + workflow.getWfName() + " \n\n Workflow: \n " + workflow.getWfName() ;

            emailNotificationService.sendEmail(email, emailSubject, emailBody);

        // Validated to Rejected: Approver to Admin
        } else if (currStatus == FormSequenceStatus.VALIDATED && newStatus == FormSequenceStatus.REJECTED){

            formSequence.setStatus(FormSequenceStatus.REJECTED);
            String email = workflow.getAdmin().getEmailAddress();
            String emailSubject = "Form rejected [" + formName + "]";
            String emailBody = "The following form has been rejected: \n " + formName + " \n\n Workflow: \n " + workflow.getWfName() ;

            emailNotificationService.sendEmail(email, emailSubject, emailBody);

        // Validated to Approved: Approver to Admin
        } else if (currStatus == FormSequenceStatus.VALIDATED && newStatus == FormSequenceStatus.APPROVED){

            formSequence.setStatus(FormSequenceStatus.APPROVED);
            String email = workflow.getAdmin().getEmailAddress();
            String emailSubject = "Form approved [" + formName + "]";
            String emailBody = "The following form has been approved: \n " + formName + " \n\n Workflow: \n " + workflow.getWfName() ;

            emailNotificationService.sendEmail(email, emailSubject, emailBody);

        // Rejected to Deleted: Admin to Vendor
        } else if (currStatus == FormSequenceStatus.REJECTED && newStatus == FormSequenceStatus.DELETED){

            formSequence.setStatus(FormSequenceStatus.DELETED);
            String email = workflow.getVendor().getEmailAddress();
            String emailSubject = "Form deleted [" + formName + "]";
            String emailBody = "The following form has been deleted: \n " + formName + " \n\n Workflow: \n " + workflow.getWfName() ;

            emailNotificationService.sendEmail(email, emailSubject, emailBody);

        } else {
            formSequence.setStatus(FormSequenceStatus.NOT_STARTED);
        }

    }

    public WorkFlow updateWorkFlowById(Long id, WorkFlow workFlowBody){

        // id = wf_id
        Optional<WorkFlow> optionalWorkFlow = workFlowRepository.findById(id);

        if(checkWorkFlowById(id)) {

            WorkFlow eWorkFlow = optionalWorkFlow.get();
            eWorkFlow.setWfName(workFlowBody.getWfName());
            eWorkFlow.setWorkFlowStatus(workFlowBody.getWorkFlowStatus());
            eWorkFlow.setWfDateline(workFlowBody.getWfDateline());
            eWorkFlow.setWfLastSubmit(workFlowBody.getWfLastSubmit());

            // update admin
            setUser(eWorkFlow, userService.findByUserId(workFlowBody.getAdmin().getUserId()));

            // update approver
            setUser(eWorkFlow, userService.findByUserId(workFlowBody.getApprover().getUserId()));

            // update vendor
            setUser(eWorkFlow, userService.findByUserId(workFlowBody.getVendor().getUserId()));


            // Add formSequence
            if(updateFormSequence(eWorkFlow, workFlowBody)){
                eWorkFlow.setWorkFlowStatus(WorkFlowStatus.COMPLETED);
            }else{
                eWorkFlow.setWorkFlowStatus(WorkFlowStatus.IN_PROGRESS);
            }

            return workFlowRepository.save(eWorkFlow);
        }else {
            return null;
        }
    }

    public void setUser(WorkFlow workFlow, User user){
        if(user instanceof Admin){
            workFlow.setAdmin((Admin)user);
        }else if(user instanceof Approver){
            workFlow.setApprover((Approver)user);
        }else if(user instanceof Vendor){
            workFlow.setVendor((Vendor)user);
        }
    }

}
