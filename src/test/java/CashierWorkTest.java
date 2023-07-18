import org.junit.jupiter.api.Test;
import shoppingCentre.CashierWork;
import shoppingCentre.Product;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jordan
 */
public class CashierWorkTest {
    private final List<Product> products = new ArrayList<>();

    public CashierWorkTest() {
        var productOne = new Product();
        productOne.name = "book";
        productOne.location = "CA";
        productOne.price = 17.99;
        productOne.quantity = 1;
        products.add(productOne);

        var productTwo = new Product();
        productTwo.name = "potato chips";
        productTwo.location = "CA";
        productTwo.price = 3.99;
        productTwo.quantity = 1;
        products.add(productTwo);
    }

    @Test
    public void addProductsTest() {
        var cashierWork = new CashierWork();
        cashierWork.registerProducts(products);
        String receipt = cashierWork.generateReceipt();
        String expectedReceipt = """
                item                     price            qty

                book                    $17.99              1
                potato chips             $3.99              1
                subtotal:                              $21.98
                tax:                                    $1.80
                total:                                 $23.78
                """;
        assertThat(receipt).isEqualTo(expectedReceipt);
    }

}
