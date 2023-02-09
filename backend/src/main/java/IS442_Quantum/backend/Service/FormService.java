package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.FormInput;
import IS442_Quantum.backend.Model.InputProperties;
import IS442_Quantum.backend.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private InputPropertiesService inputPropertiesService;

    public Form createNewForm(Form form){
        Form newForm = new Form();
        newForm.setFormName(form.getFormName());
        newForm.setDateSubmitted(form.getDateSubmitted());
        newForm.setLastEdited(form.getLastEdited());
        newForm.getFormInputs().addAll(form.getFormInputs().stream().map(formInput -> {
            InputProperties inputProperties = inputPropertiesService.findByInputId(formInput.getInputProperty().getInputId());
            FormInput newFormInput = new FormInput();
            newFormInput.setForm(newForm);
            newFormInput.setInputProperty(inputProperties);
            newFormInput.setInputValue(formInput.getInputValue());
            return newFormInput;
        }).toList()
        );
        return formRepository.save(newForm);
    }

    public Collection<Form> getAllForm(){
        return formRepository.findAll();
    }

}
