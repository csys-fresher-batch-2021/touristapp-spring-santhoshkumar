package in.santhosh;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.santhosh.validator.Validation;

@SpringBootTest
class TouristappApiSanthoshApplicationTests {

	@Autowired
	Validation validation;
	@Test
	void contextLoads() {
		boolean isValid=validation.stringValidation("Santhosh");
		assertTrue(isValid);
	
	}

}
