package shoppingCentre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Jordan
 */
public class ProductTest {
    private final Product productOne;
    private final Product productTwo;
    private final Product productThree;

    public ProductTest() {
        productOne = new Product();
        productOne.name = "book";
        productOne.location = "CA";
        productOne.price = 17.99;
        productOne.quantity = 1;

        productTwo = new Product();
        productTwo.name = "book";
        productTwo.location = "CA";
        productTwo.price = 17.99;
        productTwo.quantity = 1;

        productThree = new Product();
        productThree.name = "iPhone";
        productThree.location = "CA";
        productThree.price = 3.99;
        productThree.quantity = 1;
    }

    @Test
    public void productIdentityTest() {
        assertEquals(productOne.name, "book");
        assertEquals(productOne.location, "CA");
        assertEquals(productOne.price, 17.99, 0.01);
        assertEquals(productOne.quantity, 1);
    }

    @Test
    public void productEqualTest() {
        assertEquals(productOne, productOne);
        assertEquals(productOne, productTwo);
    }

    @Test
    public void productNotEqualTest() {
        assertNotEquals(productOne, productThree);
        assertNotEquals(new Object(), productOne);
    }
}
