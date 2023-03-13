package IS442_Quantum.backend.Repository;

import IS442_Quantum.backend.Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
    Section findBySectionId(Long sectionId);
}