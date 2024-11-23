// to get the double into two dec places and return as a double (using ".") instead of string.

import java.util.Locale;

public class DoubleFormat {
    
    public static double doubleFormater(double input){
        double output = Double.parseDouble(String.format(Locale.US, "%.2f", input));
    
        return output;
    }
}
