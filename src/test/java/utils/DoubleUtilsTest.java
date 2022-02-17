package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jordan
 */
public class DoubleUtilsTest {
    @Test
    public void roundUpTest() {
        assertEquals(DoubleUtils.roundUp(1.13), 1.15, 0.01);
        assertEquals(DoubleUtils.roundUp(1.16), 1.20, 0.01);
        assertEquals(DoubleUtils.roundUp(1.151), 1.20, 0.01);
    }

    @Test
    public void addTest() {
        assertEquals(DoubleUtils.add(1.13, 1.14), 2.27, 0.01);
        assertEquals(DoubleUtils.add(1.99, 0.02), 2.01, 0.01);
        assertEquals(DoubleUtils.add(2.55, 0.45), 3, 0.01);
    }

    @Test
    public void multiplyTest() {
        assertEquals(DoubleUtils.multiply(1.13, 1.14), 1.2882, 0.0001);
        assertEquals(DoubleUtils.multiply(0.5, 0.5), 0.25, 0.01);
        assertEquals(DoubleUtils.multiply(0.24, 0.5), 0.12, 0.01);
    }
}
