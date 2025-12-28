package com.oguzhanakduman.exception_management;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oguzhanakduman.dto.DtoEmployee;
import com.oguzhanakduman.service.IEmployeeService;
import com.oguzhanakduman.starter.ExceptionManagementStarter;

@SpringBootTest(classes = ExceptionManagementStarter.class)
class ExceptionManagementApplicationTests {
	
	@Autowired
	private IEmployeeService employeeService;

	@BeforeEach
	public void beforeEach() {
		System.out.println("BeforeEach yani test öncesi çalıştı");
	}
	
	@Test
	public void testFindEmployeeById() {
		DtoEmployee employeeById = employeeService.findEmployeeById(4L); // Büyük L ile Long verdik.
		// Burada paranteze verilen değer null ise testten kalmış oluyor false veriyor. Bir çok assert var bu şekilde.
		assertNotNull(employeeById);
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("AfterEach yani test sonrası çalıştı");
	}

}
