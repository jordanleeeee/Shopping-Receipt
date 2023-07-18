package config;

import org.jetbrains.annotations.NotNull;
import utils.FileUtils;

import java.util.*;

/**
 * @author Jordan
 */
public class TaxConfigManager {
    private static TaxConfigManager instance = null;
    private static final String configFile = "conf.json";

    private final Map<String, String> itemCategoryMap;
    private final Map<String, Map<String, Double>> taxRateMap = new HashMap<>();

    public static TaxConfigManager getInstance() {
        if (instance == null) {
            instance = new TaxConfigManager();
        }
        return instance;
    }

    private TaxConfigManager() {
        TaxConfig taxConfig = FileUtils.readJSONFile(configFile, TaxConfig.class);
        itemCategoryMap = taxConfig.categoriesMap;
        for (TaxConfig.TaxRate taxRate : taxConfig.taxRates) {
            taxRateMap.put(taxRate.country, taxRate.taxPerCategory);
        }
    }

    /**
     * get tax rate of an item in a specific location,
     *
     * @return tax rate specify from config file.
     * In case the category of such item is unknown or
     * the tax rate of a category is unknown, return the default tax rate,
     * return 0 if no configuration of that location
     */
    public double getTaxRate(@NotNull String location, @NotNull String itemName) {
        if (taxRateMap.containsKey(location)) {
            if (itemCategoryMap.containsKey(itemName) &&
                    taxRateMap.get(location).containsKey(itemCategoryMap.get(itemName))) {
                return taxRateMap.get(location).get(itemCategoryMap.get(itemName));
            }
            return taxRateMap.get(location).get("default");
        }
        return 0;
    }
}
