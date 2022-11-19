package org.demo.simpleapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SimpleCalculatorController {
    @Autowired
    private SimpleCalculatorService simpleCalculatorService;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Double> add(@RequestBody String json) throws JsonProcessingException {
        Entity entity = objectMapper.readValue(json, Entity.class);
        return simpleCalculatorService.add(entity.getFirstValue(), entity.getSecondValue());
    }

    @GetMapping(path = "/div/{val1}/{val2}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Double> divide(
            @PathVariable("val1") double val1,
            @PathVariable("val2") double val2) {
        return simpleCalculatorService.divide(val1, val2);
    }
}
