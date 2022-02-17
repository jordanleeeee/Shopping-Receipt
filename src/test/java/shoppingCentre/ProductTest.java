package shoppingCentre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductTest {

    private final Product productOne;
    private final Product productTwo;
    private final Product productThree;

    public ProductTest(){
        productOne = new Product();
        productOne.setName("book");
        productOne.setLocation("CA");
        productOne.setPrice(17.99);
        productOne.setQuantity(1);

        productTwo = new Product();
        productTwo.setName("book");
        productTwo.setLocation("CA");
        productTwo.setPrice(17.99);
        productTwo.setQuantity(1);

        productThree = new Product();
        productThree.setName("iPhone");
        productThree.setLocation("CA");
        productThree.setPrice(3.99);
        productThree.setQuantity(1);
    }

    @Test
    public void productIdentityTest(){
        assertEquals(productOne.getName(), "book");
        assertEquals(productOne.getLocation(), "CA");
        assertEquals(productOne.getPrice(), 17.99, 0.01);
        assertEquals(productOne.getQuantity(), 1);
    }

    @Test
    public void productEqualTest(){
        assertEquals(productOne, productOne);
        assertEquals(productOne, productTwo);
    }

    @Test
    public void productNotEqualTest(){
        assertNotEquals(productOne, productThree);
        assertNotEquals(new Object(), productOne);
    }
}
