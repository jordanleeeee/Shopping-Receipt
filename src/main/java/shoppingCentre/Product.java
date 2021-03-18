package shoppingCentre;

import com.opencsv.bean.CsvBindByPosition;


public class Product {
    @CsvBindByPosition(position = 0)
    private String name;
    @CsvBindByPosition(position = 1)
    private double price;
    @CsvBindByPosition(position = 2)
    private int quantity;
    @CsvBindByPosition(position = 3)
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product){
            Product product = (Product)obj;
            return product.name.equals(name) && product.location.equals(location)
                    && product.price == price && product.quantity == quantity;
        }
        return false;
    }


}
