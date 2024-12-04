// to get the double into two dec places and return as a double instead of string.
package assignment3;

public class DoubleFormat {

    public static double doubleFormater(double input){
        return Math.floor(input * 100) / 100.0;
    }
}