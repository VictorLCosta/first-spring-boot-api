package com.example.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumeric(numberTwo) || !isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumeric(numberTwo) || !isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumeric(numberTwo) || !isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumeric(numberTwo) || !isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumeric(numberTwo) || !isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        double result = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;

        return result;
    }

    @RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
    public Double sqrt(
        @PathVariable(value = "number") String number
    ) throws Exception {

        if(!isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return Math.sqrt(convertToDouble(number));
    }
    

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;

        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
