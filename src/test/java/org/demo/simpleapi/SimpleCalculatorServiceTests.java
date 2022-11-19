package org.demo.simpleapi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SimpleCalculatorServiceTests {
    private SimpleCalculatorService simpleCalculatorService;

    @BeforeAll
    public void prepareService(){
        simpleCalculatorService = new SimpleCalculatorService();
    }

    @Test
    void should_add_two_numbers(){
        Map<String, Double> result = simpleCalculatorService.add(1.1,2.2);
        assertEquals(3.3, result.get("value"), 0.00001);
    }

    @Test
    void should_divide_two_numbers(){
        Map<String, Double> result = simpleCalculatorService.divide(6,2);
        assertEquals(3,result.get("value"),0.00001);
    }

    @Test()
    void should_return_empty_map_when_zero_is_the_denominator(){
        Exception e = assertThrows(
                ArithmeticException.class,
                () -> simpleCalculatorService.divide(3,0)
        );
        assertEquals("cannot be divided by zero",e.getMessage());
    }
}
