package org.demo.simpleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class SimpleCalculatorController {
    @Autowired
    private SimpleCalculatorService simpleCalculatorService;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Double> add(@RequestBody String json) throws JsonProcessingException {
        ValuesEntity valuesEntity = objectMapper.readValue(json, ValuesEntity.class);
        return simpleCalculatorService.add(valuesEntity.getVal1(), valuesEntity.getVal2());
    }

    @GetMapping(path = "/div/{val1}/{val2}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Double> divide(
            @PathVariable("val1") double val1,
            @PathVariable("val2") double val2) {
        try {
            return simpleCalculatorService.divide(val1, val2);
        } catch (ArithmeticException arithmeticException) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY, "cannot be divided by zero", arithmeticException);
        }
    }
}
