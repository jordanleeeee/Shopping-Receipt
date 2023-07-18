package config;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jordan
 */
public class TaxConfigManagerTest {
    private final TaxConfigManager taxConfig = TaxConfigManager.getInstance();

    @Test
    public void getConfiguredTaxRateTest() {
        assertThat(taxConfig.getTaxRate("NY", "potato chips")).isEqualTo(0);
        assertThat(taxConfig.getTaxRate("CA", "potato chips")).isEqualTo(0);
        assertThat(taxConfig.getTaxRate("NY", "shirt")).isEqualTo(0);

        assertThat(taxConfig.getTaxRate("NY", "pencils")).isEqualTo(0.08875);
        assertThat(taxConfig.getTaxRate("CA", "shirt")).isEqualTo(0.0975);
    }

    @Test
    public void getUndefinedTaxRateTest() {
        assertThat(taxConfig.getTaxRate("LA", "potato chips")).isEqualTo(0);
        assertThat(taxConfig.getTaxRate("MX", "potato chips")).isEqualTo(0);
        assertThat(taxConfig.getTaxRate("CA", "iphone")).isEqualTo(0.0975);
        assertThat(taxConfig.getTaxRate("NY", "airPod")).isEqualTo(0.08875);
    }

}
