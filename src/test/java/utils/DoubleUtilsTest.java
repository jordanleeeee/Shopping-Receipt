package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jordan
 */
public class DoubleUtilsTest {
    @Test
    public void roundUpTest() {
        assertThat(DoubleUtils.roundUp(1.13)).isEqualTo(1.15);
        assertThat(DoubleUtils.roundUp(1.16)).isEqualTo(1.20);
        assertThat(DoubleUtils.roundUp(1.151)).isEqualTo(1.20);
    }

    @Test
    public void addTest() {
        assertThat(DoubleUtils.add(1.13, 1.14)).isEqualTo(2.27);
        assertThat(DoubleUtils.add(1.99, 0.02)).isEqualTo(2.01);
        assertThat(DoubleUtils.add(2.55, 0.45)).isEqualTo(3);
    }

    @Test
    public void multiplyTest() {
        assertThat(DoubleUtils.multiply(1.13, 1.14)).isEqualTo(1.2882);
        assertThat(DoubleUtils.multiply(0.5, 0.5)).isEqualTo(0.25);
        assertThat(DoubleUtils.multiply(0.24, 0.5)).isEqualTo(0.12);
    }
}
