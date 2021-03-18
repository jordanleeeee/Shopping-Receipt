package utils;

import org.json.simple.JSONObject;
import org.junit.Test;
import shoppingCentre.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileUtilsTest {
    @Test
    public void readJSONFileTest() {
        JSONObject obj = FileUtils.readJSONFile("src/test/java/utils/testJson.json");
        assertEquals(obj.get("msg"), "Hello World");
        assertEquals((double)obj.get("double"), 1.1, 0.1);
        assertArrayEquals(((List)obj.get("array")).toArray(), Arrays.asList(1.0, 2.0, 3.0).toArray());
        JSONObject innerObj = (JSONObject)obj.get("obj");
        assertEquals(innerObj.get("test"), "object");
    }

    @Test
    public void readCSVFileTest() {
        String filePath = "src/test/java/utils/testCSV.csv";
        List<Product> products = FileUtils.readCSVFile(filePath, 1, Product.class);
        List<Product> correctProducts = new ArrayList<>();
        Product productOne = new Product();
        productOne.setName("book");
        productOne.setLocation("CA");
        productOne.setPrice(17.99);
        productOne.setQuantity(1);
        correctProducts.add(productOne);

        assertArrayEquals(products.toArray(), correctProducts.toArray());
    }
}
