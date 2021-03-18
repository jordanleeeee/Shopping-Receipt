package shoppingCentre;

import config.TaxConfig;
import org.jetbrains.annotations.Nullable;
import utils.DoubleUtils;

import java.util.ArrayList;
import java.util.List;

public class CashierWork {
    private final List<Product> products = new ArrayList<>();
    private double subtotal = 0;
    private double tax = 0;

    /**
     * add list of product
     */
    public void registerProducts(@Nullable List<Product> products) {
        if(products != null){
            for(Product product: products) {
                registerProduct(product);
            }
        }
    }

    /**
     * add one of product
     */
    public void registerProduct(@Nullable Product product) {
        if(product != null){
            products.add(product);
            subtotal = DoubleUtils.add(subtotal, getItemTotal(product));
            tax = DoubleUtils.add(tax, getItemTax(product));
        }
    }


    private double getItemTotal(Product product){
        return DoubleUtils.multiply(product.getPrice(), product.getQuantity());
    }

    private double getItemTax(Product product){
        double taxRate = TaxConfig.getInstance().getTaxRate(product.getLocation(), product.getName());
        double tax = DoubleUtils.multiply(getItemTotal(product), taxRate);
        return DoubleUtils.roundUp(tax);
    }

    /**
     * generate receipt to show product purchase
     * @return string representation of receipt
     */
    public String generateReceipt(){
        StringBuilder receipt = new StringBuilder();
        receipt.append(generateReceiptRow("item", "price", "qty"));
        receipt.append("\n");
        for(Product product: products){
            receipt.append(generateReceiptRow(
                    product.getName(), String.format("$%.2f", product.getPrice()), String.valueOf(product.getQuantity())
            ));
        }
        receipt.append(generateReceiptRow("subtotal:", "", String.format("$%.2f", subtotal)));
        receipt.append(generateReceiptRow("tax:", "", String.format("$%.2f", tax)));
        receipt.append(generateReceiptRow("total:", "", String.format("$%.2f", DoubleUtils.add(subtotal, tax))));
        return receipt.toString();
    }

    private String generateReceiptRow(String col1, String col2, String col3){
        return String.format("%-15s%15s%15s\n", col1, col2, col3);
    }

}
