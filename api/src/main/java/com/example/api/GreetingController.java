package com.example.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double greeting(
        @PathVariable(value = "numberOne") String numberOne, 
        @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        
        if(!isNumeric(numberTwo) || !isNumeric(numberTwo))
            throw new Exception();

        return convertToDouble(numberTwo) + convertToDouble(numberOne);
    }

    private Double convertToDouble(String strNumber) {
        return null;
    }

    private boolean isNumeric(String strNumber) {
        return false;
    }

}
