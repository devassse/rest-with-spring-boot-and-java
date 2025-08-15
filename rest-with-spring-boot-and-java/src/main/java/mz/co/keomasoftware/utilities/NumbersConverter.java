package mz.co.keomasoftware.utilities;

import mz.co.keomasoftware.exceptions.UnsupportedMathOperationException;

public class NumbersConverter {

    // Utility Methods
    public static boolean isNumeric (String strNumber){
        String regex = "[-+]?[0-9]*\\.?[0-9]+";
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
//        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
        return number.matches(regex);
    }

    public static Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if(strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please enter a Valide NUMBER");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }


}
