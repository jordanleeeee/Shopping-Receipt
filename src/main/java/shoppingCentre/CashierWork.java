package shoppingCentre;

import config.TaxConfigManager;
import org.jetbrains.annotations.NotNull;
import utils.DoubleUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jordan
 */
public class CashierWork {
    private final List<Product> products = new ArrayList<>();
    private double subtotal = 0;
    private double tax = 0;

    /**
     * add list of product
     */
    public void registerProducts(@NotNull List<Product> products) {
        for (Product product : products) {
            registerProduct(product);
        }
    }

    /**
     * add one of product
     */
    public void registerProduct(@NotNull Product product) {
        products.add(product);
        subtotal = DoubleUtils.add(subtotal, getItemTotal(product));
        tax = DoubleUtils.add(tax, getItemTax(product));
    }


    private double getItemTotal(Product product) {
        return DoubleUtils.multiply(product.price, product.quantity);
    }

    private double getItemTax(Product product) {
        double taxRate = TaxConfigManager.getInstance().getTaxRate(product.location, product.name);
        double tax = DoubleUtils.multiply(getItemTotal(product), taxRate);
        return DoubleUtils.roundUp(tax);
    }

    /**
     * generate receipt to show product purchase
     *
     * @return string representation of receipt
     */
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append(generateReceiptRow("item", "price", "qty"));
        receipt.append("\n");
        for (Product product : products) {
            receipt.append(generateReceiptRow(
                    product.name, String.format("$%.2f", product.price), String.valueOf(product.quantity)
            ));
        }
        receipt.append(generateReceiptRow("subtotal:", "", String.format("$%.2f", subtotal)));
        receipt.append(generateReceiptRow("tax:", "", String.format("$%.2f", tax)));
        receipt.append(generateReceiptRow("total:", "", String.format("$%.2f", DoubleUtils.add(subtotal, tax))));
        return receipt.toString();
    }

    private String generateReceiptRow(String col1, String col2, String col3) {
        return String.format("%-15s%15s%15s\n", col1, col2, col3);
    }
}
