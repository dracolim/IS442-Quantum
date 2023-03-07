package IS442_Quantum.backend.Service;

import IS442_Quantum.backend.Model.Section;
import IS442_Quantum.backend.Repository.SectionRepository;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public Iterable<Section> getAllSections(){
        return sectionRepository.findAll();
    }

    public Section findBySectionId(Long sectionId){
        return sectionRepository.findBySectionId(sectionId);
    }



}
