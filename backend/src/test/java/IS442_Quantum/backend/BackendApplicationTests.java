package IS442_Quantum.backend;

import IS442_Quantum.backend.Model.Vendor;
import IS442_Quantum.backend.Model.WorkFlow;
import IS442_Quantum.backend.Repository.UserRepository;
import IS442_Quantum.backend.Repository.WorkFlowRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashSet;

@SpringBootTest
class BackendApplicationTests {
	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateVendorWithWorkFlow() {
		Vendor vendor1 = new Vendor();
		vendor1.setUserName("Vendor1");
		vendor1.setPassword("123456");
		vendor1.setEmailAddress("vendor1@gmail.com");
		vendor1.setCompanyName("Vendor1 Company");
		vendor1.setOfficeAddress("Vendor1 Office Address");
		vendor1.setOfficeTel("0123456789");
		vendor1.setOfficeFax("0123456789");
		vendor1.setRegistrationNo(12L);
		vendor1.setBusinessType("Vendor1 Business Type");
		vendor1.setEvaluationId("1");

		WorkFlow workflow1 = new WorkFlow();
		workflow1.setWfName("Workflow1");
		workflow1.setWfDateline(new Date());
		workflow1.setWfLastSubmit(new Date());
		workflow1.setValidated(true);


		vendor1.addWorkflow(workflow1);

		userRepository.save(vendor1);
	}

}
