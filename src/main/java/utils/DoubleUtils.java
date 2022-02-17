package utils;

import java.math.BigDecimal;

/**
 * @author Jordan
 */
public class DoubleUtils {
    public static double add(double a, double b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).doubleValue();
    }

    public static double multiply(double a, double b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)).doubleValue();
    }

    /**
     * rounded up to the nearest 0.05
     *
     * @param a number to be round up
     * @return result
     */
    public static double roundUp(double a) {
        return Math.ceil(a * 20.0) / 20.0;
    }
}
