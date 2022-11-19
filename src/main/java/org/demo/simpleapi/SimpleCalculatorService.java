package org.demo.simpleapi;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SimpleCalculatorService {

    public Map<String, Double> add(double a, double b) {
        double result = a + b;
        return new HashMap<>(
                Map.of("value", result)
        );
    }

    public Map<String, Double> divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("cannot be divided by zero");
        }
        double result = a / b;
        return new HashMap<>(Map.of("value", result)
        );
    }
}
