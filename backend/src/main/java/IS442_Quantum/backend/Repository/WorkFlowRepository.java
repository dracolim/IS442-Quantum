package IS442_Quantum.backend.Repository;


import IS442_Quantum.backend.Model.Form;
import IS442_Quantum.backend.Model.WorkFlow;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface WorkFlowRepository extends JpaRepository<WorkFlow, Long>  {
    @Query("SELECT w FROM WorkFlow w WHERE w.workFlowStatus =IS442_Quantum.backend.Enums.WorkFlowStatus.IN_PROGRESS")
    ArrayList<WorkFlow> findPendingWorkFlow();


}
