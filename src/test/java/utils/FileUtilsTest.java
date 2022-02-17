package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shoppingCentre.Product;

import java.util.ArrayList;
import java.util.List;

public class FileUtilsTest {
    @Test
    public void readCSVFileTest() {
        String filePath = "src/test/resources/testCSV.csv";
        List<Product> products = FileUtils.readCSVFile(filePath, 1, Product.class);
        List<Product> correctProducts = new ArrayList<>();
        Product productOne = new Product();
        productOne.setName("book");
        productOne.setLocation("CA");
        productOne.setPrice(17.99);
        productOne.setQuantity(1);
        correctProducts.add(productOne);

        Assertions.assertArrayEquals(products.toArray(), correctProducts.toArray());
    }
}
