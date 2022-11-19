package org.demo.simpleapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class SimpleApiCalculatorIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_appropriate_sum_when_correct_post_request_is_sent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/add")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("{\"val1\":2.1,\"val2\":2}"))
                .andExpect(status().is(200))
                .andExpect(content().string("{\"value\":4.1}"));
    }

    @Test
    void should_return_appropriate_quotient_when_correct_get_request_is_sent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/div/4/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().string("{\"value\":2.0}"));
    }

    @Test
    void should_throw_exception_when_zero_is_in_the_denominator() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/div/4/0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(422));
    }
}
