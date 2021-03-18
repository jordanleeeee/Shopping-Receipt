import org.junit.Test;
import shoppingCentre.CashierWork;
import shoppingCentre.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CashierWorkTest {

    private final CashierWork cashierWork = new CashierWork();
    private final List<Product> products = new ArrayList<>();

    public CashierWorkTest(){
        Product productOne = new Product();
        productOne.setName("book");
        productOne.setLocation("CA");
        productOne.setPrice(17.99);
        productOne.setQuantity(1);
        products.add(productOne);

        Product productTwo = new Product();
        productTwo.setName("potato chips");
        productTwo.setLocation("CA");
        productTwo.setPrice(3.99);
        productTwo.setQuantity(1);
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
