package br.com.erudio.request.converts;

import br.com.erudio.exceptions.UnsurpportedMathOperationsExceptions;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class NumberConverts {


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
