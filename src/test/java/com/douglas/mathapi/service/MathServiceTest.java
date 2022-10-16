package com.douglas.mathapi.service;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MathServiceTest {

    MathService mathService = new MathService();

    @Test
    public void maxNumbers(){

        List<Double> list = new ArrayList<>(Arrays.asList(1.0, 9.0, 4.0, 5.0));
        List<Double> listReturned = mathService.maxNumbers(list, 2);

        assertEquals(listReturned, Arrays.asList(9.0, 5.0));
    }

    @Test
    public void minNumbers(){

        List<Double> list = new ArrayList<>(Arrays.asList(1.0, 9.0, 4.0, 5.0));
        List<Double> listReturned = mathService.minNumbers(list, 3);

        assertEquals(listReturned, Arrays.asList(1.0, 4.0, 5.0));
    }

    @Test
    public void average(){

        List<Double> list = new ArrayList<>(Arrays.asList(1.0, 9.0, 4.0, 5.0, 50.0, 65.5));
        Double average = mathService.average(list);

        assertEquals(average, 22.416666666666668);
    }

    @Test
    public void median_even_numbers(){
        List<Double> list =
                new ArrayList<>(Arrays
                        .asList(3.0, 13.0, 7.0, 5.0, 21.0, 23.0, 23.0, 40.0, 23.0, 14.0, 12.0, 56.0, 23.0, 29.0));
        Double median = mathService.median(list);

        assertEquals(median, 22.00);
    }

    @Test
    public void median_odd_numbers(){
        List<Double> list =
                new ArrayList<>(Arrays
                        .asList(3.0, 13.0, 7.0, 5.0, 21.0, 23.0, 39.0, 23.0, 40.0, 23.0, 14.0, 12.0, 56.0, 23.0, 29.0));
        Double median = mathService.median(list);

        assertEquals(median, 23.00);
    }

    @Test
    public void percentile(){
        List<Double> list =
                new ArrayList<>(Arrays
                        .asList(77.0, 76.0, 88.0, 85.0, 87.0, 78.0, 80.0, 95.0, 90.0, 83.0, 89.0, 93.0, 75.0, 70.0, 67.0));
        Double percentile = mathService.percentile(list, 66.0);

        assertEquals(percentile, 87.00);

    }

    @Test
    public void percentile_max_rank(){
        List<Double> list =
                new ArrayList<>(Arrays
                        .asList(77.0, 76.0, 88.0, 85.0, 87.0, 78.0, 80.0, 95.0, 90.0, 83.0, 89.0, 93.0, 75.0, 70.0, 67.0));
        Double percentile = mathService.percentile(list, 100.0);

        assertEquals(percentile, 95.00);

    }
}
