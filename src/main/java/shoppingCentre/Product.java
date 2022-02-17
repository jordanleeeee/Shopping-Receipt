package shoppingCentre;

import com.opencsv.bean.CsvBindByName;


/**
 * @author Jordan
 */
public class Product {
    @CsvBindByName(column = "name", required = true)
    public String name;
    @CsvBindByName(column = "price", required = true)
    public double price;
    @CsvBindByName(column = "quantity", required = true)
    public int quantity;
    @CsvBindByName(column = "location", required = true)
    public String location;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product product = (Product) obj;
            return product.name.equals(name) && product.location.equals(location)
                    && product.price == price && product.quantity == quantity;
        }
        return false;
    }


}
