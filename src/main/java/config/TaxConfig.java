package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * @author Jordan
 */
public class TaxConfig {
    @NotNull
    @JsonProperty(value = "categoriesMap", required = true)
    public Map<String, String> categoriesMap;

    @NotNull
    @JsonProperty(value = "taxRates", required = true)
    public List<TaxRate> taxRates;

    public static class TaxRate {
        @NotNull
        @JsonProperty(value = "country", required = true)
        public String country;

        @NotNull
        @JsonProperty(value = "tax", required = true)
        public Map<String, Double> taxPerCategory;
    }
}
