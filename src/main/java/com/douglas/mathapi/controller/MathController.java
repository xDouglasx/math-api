package com.douglas.mathapi.controller;

import com.douglas.mathapi.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * math-api controller
 */
@RestController
@RequestMapping(value = "/math")
public class MathController {

    private static final String NUMBERS_PARAMETER  = "numbers";

    @Autowired
    private MathService mathService;

    /**
     *
     * @param numbers list of numbers that will be searched to find the max numbers
     * @param quantity quantity of max numbers that will be returned
     * @return return a list of max numbers
     */
    @GetMapping(value = "/max")
    public ResponseEntity<List<Double>> getMaxNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers,
            @RequestParam(name = "quantity", defaultValue = "1") Integer quantity){

        return ResponseEntity.ok(mathService.maxNumbers(numbers, quantity));
    }

    /**
     *
     * @param numbers list of numbers that will be searched to find the min numbers
     * @param quantity quantity of min numbers that will be returned
     * @return return a list of min numbers
     */
    @GetMapping(value = "/min")
    public ResponseEntity<List<Double>> getMinNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers,
            @RequestParam(name = "quantity", defaultValue = "1") Integer quantity){

        return ResponseEntity.ok(mathService.minNumbers(numbers, quantity));
    }

    /**
     *
     * @param numbers list of numbers that will be used to find the average
     * @return return the average of numbers
     */
    @GetMapping(value = "/average")
    public ResponseEntity<Double> getAverageOfNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers){
        return ResponseEntity.ok(mathService.average(numbers));
    }

    /**
     *
     * @param numbers list of numbers that will be used to find the median
     * @return return the median of numbers
     */
    @GetMapping(value = "/median")
    public ResponseEntity<Double> getMedianOfNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers){
        return ResponseEntity.ok(mathService.median(numbers));
    }

    /**
     *
     * @param numbers list of numbers that will be used to find the percentile
     * @param rank selected rank of the percentile 0 => Rank <= 100
     * @return return percentile of numbers at the rank selected
     */
    @GetMapping(value = "/percentile")
    public ResponseEntity<Double> getPercentileOfNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers,
            @RequestParam(required = true, name = "rank") Double rank){
        return ResponseEntity.ok(mathService.percentile(numbers, rank));
    }
}
