import shoppingCentre.CashierWork;
import shoppingCentre.Product;
import utils.FileUtils;

import java.util.List;
import java.util.Scanner;

public class GenerateReceipt {
    public static void main(String[] args){
        System.out.println("please specify the input record file(.csv) path");
        String filePath = new Scanner(System.in).next();
        System.out.println("loading shopping record...");
        List<Product> products = FileUtils.readCSVFile(filePath, 1, Product.class);

        CashierWork cashierWork = new CashierWork();
        System.out.println("cashier work in progress...");
        cashierWork.registerProducts(products);
        System.out.println("generating receipt...");
        System.out.println(cashierWork.generateReceipt());
    }
}
