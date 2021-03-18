package config;

import org.json.simple.JSONObject;
import org.jetbrains.annotations.NotNull;
import utils.FileUtils;

import java.util.*;

public class TaxConfig {
    private static TaxConfig instance = null;
    private static final String configFileLocation = "conf.json";
    private final Map<String, String> itemCategoryMap = new HashMap<>();
    private final HashMap<String, Map<String, Double>> taxRateMap = new HashMap<>();

    public static TaxConfig getInstance(){
        if(instance == null){
            instance = new TaxConfig();
        }
        return instance;
    }
    private TaxConfig(){
        JSONObject configDetails = FileUtils.readJSONFile(configFileLocation);
        //Load data to program
        loadProductCategories(configDetails);
        loadTaxRateMap(configDetails);
    }

    private void loadProductCategories(JSONObject configDetails){
        try {
            JSONObject categoriesMap = (JSONObject)configDetails.get("categoriesMap");
            for (Object productName : categoriesMap.keySet()) {
                String productCategories = (String) categoriesMap.get(productName);
                itemCategoryMap.put((String) productName, productCategories);
            }
        } catch (ClassCastException e){
            System.err.println("invalid config file data");
            System.exit(-1);
        } catch (NullPointerException e){
            System.err.println("missing data \"categories\" in config file");
            System.exit(-1);
        }
    }

    private void loadTaxRateMap(JSONObject configDetails){
        try {
            JSONObject taxRateDetails = (JSONObject)configDetails.get("taxRate");
            for(Object locationTaxDetails: taxRateDetails.keySet()){
                Map<String, Double> taxMap = new HashMap<>();
                JSONObject categoriesTaxMapping = (JSONObject)taxRateDetails.get(locationTaxDetails);
                for(Object category: categoriesTaxMapping.keySet()){
                    taxMap.put((String)category, (Double)categoriesTaxMapping.get(category));
                }
                taxRateMap.put((String)locationTaxDetails, taxMap);
            }
        } catch (ClassCastException e){
            System.err.println("invalid config file data");
            System.exit(-1);
        } catch (NullPointerException e){
            System.err.println("missing data \"taxRate\" in config file");
            System.exit(-1);
        }
    }

    /**
     * get tax rate of an item in a specific location,
     * @return tax rate specify from config file.
     * In case the category of such item is unknown or
     * the tax rate of a category is unknown, return the default tax rate,
     * return 0 if no configuration of that location
     */
    public double getTaxRate(@NotNull String location, @NotNull String itemName){
        if(taxRateMap.containsKey(location)) {
            if(itemCategoryMap.containsKey(itemName) &&
                    taxRateMap.get(location).containsKey(itemCategoryMap.get(itemName))){
                return taxRateMap.get(location).get(itemCategoryMap.get(itemName));
            }
            return taxRateMap.get(location).get("default");
        }
        return 0;
    }

}
