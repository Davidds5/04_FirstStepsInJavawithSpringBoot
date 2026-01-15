package br.com.erudio.controllers;

import br.com.erudio.exceptions.UnsurpportedMathOperationsExceptions;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {


    // soma
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || (!isNumeric(numberTwo))) throw new UnsurpportedMathOperationsExceptions("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    // subtracao
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if (!isNumeric(numberOne) || (isNumeric(numberTwo))) throw new UnsurpportedMathOperationsExceptions("Please set a numeric value");
        Double result = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return result;
    }

    // multiplicacao
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    )throws Exception{
        if (!isNumeric(numberOne) || (!isNumeric(numberTwo))) throw new UnsurpportedMathOperationsExceptions("Please set a numeric value");
        Double result = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return result;
    }

    // divisao
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    )throws Exception{
        if (!isNumeric(numberOne) || (!isNumeric(numberTwo))) throw new UnsurpportedMathOperationsExceptions("Please set a numeric value");
        Double result = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return result;
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception {
        if (!isNumeric(numberOne) || (!isNumeric(numberTwo))) throw new UnsurpportedMathOperationsExceptions("Please set a numeric value");
        Double result = convertToDouble(numberOne) + convertToDouble(numberTwo)/ 2;
        return result;
    }
    @RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }
        Double result = Math.sqrt(convertToDouble(number));
        return result;
    }





    @NotNull
    @Contract("null -> fail")
    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsurpportedMathOperationsExceptions("Please set a numeric value!");

        String number = strNumber.replace(",",".");

        if (!number.matches("[-+]?[0-9]*\\.?[0-9]+")) throw new UnsurpportedMathOperationsExceptions("Please set a numeric value!");
        return Double.parseDouble(number);


    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",",".");
        return (number.matches( "[-+]?[0-9]*\\.?[0-9]+"));


    }


}
