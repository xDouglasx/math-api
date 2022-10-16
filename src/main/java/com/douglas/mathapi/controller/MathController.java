package com.douglas.mathapi.controller;

import com.douglas.mathapi.controller.model.ResponseWrapper;
import com.douglas.mathapi.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    private static final String NUMBERS_PARAMETER  = "numbers";

    @Autowired
    private MathService mathService;

    @GetMapping(value = "/max")
    public ResponseEntity<List<Double>> getMaxNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers,
            @RequestParam(name = "quantity", defaultValue = "1") Integer quantity){

        return ResponseEntity.ok(mathService.maxNumbers(numbers, quantity));
    }

    @GetMapping(value = "/min")
    public ResponseEntity<List<Double>> getMinNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers,
            @RequestParam(name = "quantity", defaultValue = "1") Integer quantity){

        return ResponseEntity.ok(mathService.minNumbers(numbers, quantity));
    }

    @GetMapping(value = "/average")
    public ResponseEntity<Double> getAverageOfNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers){
        return ResponseEntity.ok(mathService.average(numbers));
    }

    @GetMapping(value = "/median")
    public ResponseEntity<Double> getMedianOfNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers){
        return ResponseEntity.ok(mathService.median(numbers));
    }

    @GetMapping(value = "/percentile")
    public ResponseEntity<Double> getPercentileOfNumbers(
            @RequestParam(required = true, name = NUMBERS_PARAMETER) List<Double> numbers,
            @RequestParam(required = true, name = "rank") Double rank){
        return ResponseEntity.ok(mathService.percentile(numbers, rank));
    }
}
