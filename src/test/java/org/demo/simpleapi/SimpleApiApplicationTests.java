package org.demo.simpleapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SimpleApiApplicationTests {

	@Autowired
	SimpleCalculatorController simpleCalculatorController;

	@Autowired
	SimpleCalculatorService simpleCalculatorService;

	@Test
	void contextLoads() {
		assertThat(simpleCalculatorController).isNotNull();
		assertThat(simpleCalculatorService).isNotNull();
	}
}
