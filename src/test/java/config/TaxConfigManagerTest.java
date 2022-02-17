package config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jordan
 */
public class TaxConfigManagerTest {
    private final TaxConfigManager taxConfig = TaxConfigManager.getInstance();

    @Test
    public void getConfiguredTaxRateTest() {
        assertEquals(taxConfig.getTaxRate("NY", "potato chips"), 0, 0.00001);
        assertEquals(taxConfig.getTaxRate("CA", "potato chips"), 0, 0.00001);
        assertEquals(taxConfig.getTaxRate("NY", "shirt"), 0, 0.00001);

        assertEquals(taxConfig.getTaxRate("NY", "pencils"), 0.08875, 0.00001);
        assertEquals(taxConfig.getTaxRate("CA", "shirt"), 0.0975, 0.00001);
    }

    @Test
    public void getUndefinedTaxRateTest() {
        assertEquals(taxConfig.getTaxRate("LA", "potato chips"), 0, 0.00001);
        assertEquals(taxConfig.getTaxRate("MX", "potato chips"), 0, 0.00001);
        assertEquals(taxConfig.getTaxRate("CA", "iphone"), 0.0975, 0.00001);
        assertEquals(taxConfig.getTaxRate("NY", "airPod"), 0.08875, 0.00001);
    }

}
