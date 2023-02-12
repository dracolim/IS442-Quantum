package IS442_Quantum.backend.Repository;


import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.WorkFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkFlowRepository extends JpaRepository<WorkFlow, Long>  {

}
