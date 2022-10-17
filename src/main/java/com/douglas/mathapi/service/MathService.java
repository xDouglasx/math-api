package com.douglas.mathapi.service;

import com.douglas.mathapi.exception.InvalidRankException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MathService {

    /**
     *
     * @param numbers list of numbers used to find max numbers
     * @param quantity quantity of numbers to be returned as max numbers
     * @return list of max numbers
     */
    public List<Double> maxNumbers(List<Double> numbers, Integer quantity) {
        return sortList(numbers, true)
                .stream()
                .limit(quantity)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param numbers list of numbers used to find min numbers
     * @param quantity quantity of numbers to be returned as min numbers
     * @return list of min numbers
     */
    public List<Double> minNumbers(List<Double> numbers, Integer quantity){
        return sortList(numbers,false)
                .stream()
                .limit(quantity)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param numbers list of numbers used to find average
     * @return return the average of numbers
     */
    public Double average(List<Double> numbers){
        return numbers
                .stream()
                .mapToDouble(n -> n)
                .average()
                .orElse(0.0);
    }

    /**
     *
     * @param numbers list of numbers used to find median
     * @return median value
     */
    public Double median(List<Double> numbers){
        List<Double> sortedList = sortList(numbers,false);
        if(!(sortedList.size() % 2 == 0)){
            return sortedList.get(sortedList.size() / 2);
        } else {
            return (sortedList.get(sortedList.size() / 2) + sortedList.get((sortedList.size() / 2) -1)) / 2;
        }
    }

    /**
     *
     * @param numbers numbers used to find percentile
     * @param rank percentile rank
     * @return return percentile using the nearest rank method
     */
    public Double percentile(List<Double> numbers, Double rank){
        if(rank < 0 || rank > 100){
            throw new InvalidRankException("Rank must be between 0 and 100.");
        }

        List<Double> sortedList = sortList(numbers, false);
        return rank == 100 ? sortedList.get(sortedList.size() -1) :
                sortedList.get((int) Math.ceil(rank/100 * numbers.size()) -1);

    }

    /**
     *
     * @param numbers list of numbers to be sorted
     * @param isDescending flag to ask for ascending or descending order
     * @return return sorted list
     */
    private List<Double> sortList(List<Double> numbers, boolean isDescending){
        if(!isDescending){ Collections.sort(numbers); }
        else {
            numbers.sort(Collections.reverseOrder());
        }
        return numbers;
    }
}
