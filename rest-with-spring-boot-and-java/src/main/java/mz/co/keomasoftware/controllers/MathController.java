package mz.co.keomasoftware.controllers;

import mz.co.keomasoftware.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static mz.co.keomasoftware.utilities.NumbersConverter.convertToDouble;
import static mz.co.keomasoftware.utilities.NumbersConverter.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {


    // http://localhost:8080/math/sum/3/2
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a Valide NUMBER");
        System.out.println("Number One"+ numberOne);
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    // http://localhost:8080/math/subtract/3/2
    @RequestMapping("/subtract/{numberOne}/{numberTwo}")
    public Double subtract(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a Valide NUMBER");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    // http://localhost:8080/math/divide/3/2
    @RequestMapping("/divide/{numberOne}/{numberTwo}")
    public Double divide(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a Valide NUMBER");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    // http://localhost:8080/math/multiply/3/2
    @RequestMapping("/multiply/{numberOne}/{numberTwo}")
    public Double multiply(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a Valide NUMBER");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/avarage/{numberOne}/{numberTwo}")
    public Double avarage(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter a Valide NUMBER");
        return sum(numberOne,numberTwo)/2;
    }

    @RequestMapping("/square/{number}")
    public Double square(
            @PathVariable("number") String number) throws Exception {
        if(!isNumeric(number))
            throw new UnsupportedMathOperationException("Please enter a Valide NUMBER");

        if(convertToDouble(number) < 0)
            throw new UnsupportedMathOperationException("Please enter a NUMBER greater than ZERO");
        Double r = Math.sqrt(convertToDouble(number));
        return convertToDouble(number) * convertToDouble(number);

    }
}
