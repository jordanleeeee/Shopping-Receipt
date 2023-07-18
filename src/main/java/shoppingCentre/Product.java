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
}
