package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shoppingCentre.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jordan
 */
public class FileUtilsTest {
    @Test
    public void readCSVFileTest() {
        String filePath = "src/test/resources/testCSV.csv";
        List<Product> products = FileUtils.readCSVFile(filePath, Product.class);
        List<Product> correctProducts = new ArrayList<>();
        Product productOne = new Product();
        productOne.name = "book";
        productOne.location = "CA";
        productOne.price = 17.99;
        productOne.quantity = 1;
        correctProducts.add(productOne);

        Assertions.assertArrayEquals(products.toArray(), correctProducts.toArray());
    }
}
