package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shoppingCentre.Product;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jordan
 */
public class FileUtilsTest {
    @Test
    public void readCSVFileTest() {
        List<Product> products = FileUtils.readCSVFile("testCSV.csv", Product.class);

        var expectedProduct = new Product();
        expectedProduct.name = "book";
        expectedProduct.location = "CA";
        expectedProduct.price = 17.99;
        expectedProduct.quantity = 1;

        assertThat(products).hasSize(1);
        assertThat(products.get(0)).usingRecursiveComparison().isEqualTo(expectedProduct);
    }
}
