package com.example.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.converters.NumberConverter;
import com.example.exceptions.UnsupportedMathOperationException;
import com.example.math.SimpleMath;

@RestController
public class MathController {

    // private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
    public Double sqrt(
        @PathVariable(value = "number") String number
    ) throws Exception {

        if(!NumberConverter.isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return math.squareRoot(NumberConverter.convertToDouble(number));
    }

}
