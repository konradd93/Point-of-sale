package com.konrad;

import com.konrad.model.Product;
import com.konrad.output.Printer;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Product> productsOnReceipt = new ArrayList<Product>();
    private double totalSum;
    private Printer printer = new Printer();

    public void addProductToReceipt(Product product){
        productsOnReceipt.add(product);
        addPriceToSum(product.getPrice());
    }

    private void addPriceToSum(double price) {
        totalSum+=price;
    }

    public void printReceipt(){
        StringBuilder receipt = new StringBuilder();
        for (Product product:productsOnReceipt) {
            receipt.append(product.getName()).append(" - ").append(product.getPrice()).append("zł\n");
        }
        receipt.append("--------------------\n").append("Suma: ").append(totalSum).append("zł");
        printer.printReceipt(receipt.toString());
    }
}
