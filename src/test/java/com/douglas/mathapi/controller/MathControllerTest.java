package com.douglas.mathapi.controller;

import com.douglas.mathapi.service.MathService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

    @MockBean
    MathService mathService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void max_numbers_success() throws Exception {

        when(mathService.maxNumbers(any(), any(Integer.class)))
        .thenReturn(Arrays.asList(10.0, 6.0));

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/math/max?numbers=1,2,4,7,3,6,5,10&quantity=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists());

    }

    @Test
    public void min_numbers_success() throws Exception {

        when(mathService.maxNumbers(any(), any(Integer.class)))
                .thenReturn(Arrays.asList(10.0, 6.0));

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/math/min?numbers=1,2,4,7,3,6,5,10&quantity=3")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists());

    }

    @Test
    public void average_success() throws Exception {

        when(mathService.maxNumbers(any(), any(Integer.class)))
                .thenReturn(Arrays.asList(10.0, 6.0));

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/math/average?numbers=1,2,4,7,3,6,5,10")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists());

    }

    @Test
    public void median_success() throws Exception {

        when(mathService.maxNumbers(any(), any(Integer.class)))
                .thenReturn(Arrays.asList(10.0, 6.0));

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/math/median?numbers=1,2,4,7,3,6,5,10")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists());

    }

    @Test
    public void percentile_success() throws Exception {

        when(mathService.maxNumbers(any(), any(Integer.class)))
                .thenReturn(Arrays.asList(10.0, 6.0));

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/math/percentile?numbers=1,2,4,7,3,6,5,10&rank=25")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists());

    }
}
