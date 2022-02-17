import org.junit.jupiter.api.Test;
import shoppingCentre.CashierWork;
import shoppingCentre.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jordan
 */
public class CashierWorkTest {

    private final CashierWork cashierWork = new CashierWork();
    private final List<Product> products = new ArrayList<>();

    public CashierWorkTest() {
        Product productOne = new Product();
        productOne.name = "book";
        productOne.location = "CA";
        productOne.price = 17.99;
        productOne.quantity = 1;
        products.add(productOne);

        Product productTwo = new Product();
        productTwo.name = "potato chips";
        productTwo.location = "CA";
        productTwo.price = 3.99;
        productTwo.quantity = 1;
        products.add(productTwo);
    }

    @Test
    public void addProductsTest() {
        cashierWork.registerProducts(products);
        String receipt = cashierWork.generateReceipt();
        String correctReceipt = "" +
                "item                     price            qty\n" +
                "\n" +
                "book                    $17.99              1\n" +
                "potato chips             $3.99              1\n" +
                "subtotal:                              $21.98\n" +
                "tax:                                    $1.80\n" +
                "total:                                 $23.78\n";
        assertEquals(receipt, correctReceipt);
    }

}
