// to get the double into two dec places and return as a double instead of string.
package assignment3;

public class DoubleFormat {

    public static double truncate(double value) {
        return Math.floor(value * 100.0) / 100.0; // Ensures no rounding up
    }

    // Format value consistently as string with two decimal places
    public static String formatToTwoDecimals(double value) {
        return String.format("%.2f", truncate(value));
    }

    // Optionally include rounding 
    public static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}