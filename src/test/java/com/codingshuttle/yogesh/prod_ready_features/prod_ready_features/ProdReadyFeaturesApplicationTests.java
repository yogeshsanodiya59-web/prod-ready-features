package com.codingshuttle.yogesh.prod_ready_features.prod_ready_features;

import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.cleint.EmployeeClient;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdReadyFeaturesApplicationTests {

	@Autowired
	  private EmployeeClient employeeClient;

	@Test
	void getAllEmployeeTest(){
		List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	void getEmployeeByIdTest(){
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(1L);
		System.out.println(employeeDTO);
	}

//	@Test
//	void createNewEmployeeTest(){
//		EmployeeDTO employeeDTO = new EmployeeDTO(null ,"yogesh" , "yogesh@gmail.com" , 2 ,"USER" ,5000.0 , LocalDate.of(20202 ,12,1) ,true );
//		EmployeeDTO savedEmployeeDTO = EmployeeClient.createNewEmployee(employeeDTO);
//		System.out.println(savedEmployeeDTO);
//	}

}
