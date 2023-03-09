package IS442_Quantum.backend.Controller;


import IS442_Quantum.backend.Model.Section;
import IS442_Quantum.backend.Service.SectionService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Data
public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/sections")
    public ResponseEntity<?> getAllSections() {
        return new ResponseEntity<>(sectionService.getAllSections(), HttpStatus.OK);
    }

    @GetMapping("/section/{id}")
    public ResponseEntity<?> getSectionById(@PathVariable Long id) {
        return new ResponseEntity<>(sectionService.findBySectionId(id), HttpStatus.OK);
    }

    @PostMapping(value = "/form/{formId}/section")
    public ResponseEntity<?> newSection(@RequestBody Section newSection, @PathVariable Long formId){
       if (newSection != null &&
            newSection.getTitle() != null &&
            newSection.getDescription() != null
        ){
            return new ResponseEntity<>(sectionService.createNewSection(formId, newSection), HttpStatus.OK);
        }
        return new ResponseEntity<>("creation failed", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/form/{formId}/section/{sectionId}")
    public ResponseEntity<?> newSection(@RequestBody Section newSection, @PathVariable Long formId, @PathVariable Long sectionId){
       if (newSection != null && newSection.getQuestions() != null
        ){
            return new ResponseEntity<>(sectionService.addQuestions(formId, sectionId, newSection), HttpStatus.OK);
        }
        return new ResponseEntity<>("creation failed", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/section/{id}")
    public ResponseEntity<?> deleteSectionById(@PathVariable Long id){
        if(id == 0 || !sectionService.checkSectionById(id)){
            return new ResponseEntity<>("Delete failed, please provide a valid section ID", HttpStatus.NOT_FOUND);
        } else {
            Section tempSection = sectionService.findBySectionId(id);
            sectionService.deleteSectionById(id);
            return new ResponseEntity<>(tempSection, HttpStatus.OK);
        }
    }

    @PutMapping("/form/{formId}/section/{sectionId}")
    public ResponseEntity<?> updateSectionById(@PathVariable Long formId, @PathVariable Long sectionId, @RequestBody Section sectionBody){
        if(sectionId == 0 || !sectionService.checkSectionById(sectionId)){
            return new ResponseEntity<>("Update failed, please provide a valid section ID", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(sectionService.updateSection(formId, sectionId, sectionBody), HttpStatus.OK);
        }
    }

}
