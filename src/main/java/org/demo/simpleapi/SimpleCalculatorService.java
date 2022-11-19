package org.demo.simpleapi;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SimpleCalculatorService {

    public Map<String, Double> add(double val1, double val2) {
        double sum = val1 + val2;
        return new HashMap<>(
                Map.of("value", sum)
        );
    }

    public Map<String, Double> divide(double val1, double val2) throws ArithmeticException {
        if (val2 == 0) {
            throw new ArithmeticException("cannot be divided by zero");
        }
        double quotient = val1 / val2;
        return new HashMap<>(Map.of("value", quotient));
    }
}
