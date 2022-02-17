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
    @JsonProperty("categoriesMap")
    public Map<String, String> categoriesMap;

    @NotNull
    @JsonProperty("taxRates")
    public List<TaxRate> taxRates;

    public static class TaxRate {
        @NotNull
        @JsonProperty("country")
        public String country;

        @NotNull
        @JsonProperty("tax")
        public Map<String, Double> taxPerCategory;
    }
}
