package com.konrad.input;

import com.konrad.output.LCDdisplay;
import com.konrad.Receipt;
import com.konrad.model.Product;
import com.konrad.service.FakeProductService;

import java.util.ArrayList;
import java.util.List;

public class BarCodesScanner{

    private FakeProductService fakeProductService = new FakeProductService();
    private List<Product> allProducts = new ArrayList<>();
    private Receipt receipt = new Receipt();
    private LCDdisplay lcdDisplay = new LCDdisplay();
    private boolean isInDB = false;
    private StringBuilder message;

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public void scan(String barCode){
        setAllProducts(fakeProductService.findAll());
        if(barCode.isEmpty()) printNotFoundedProductOnLCDOrInvalidBarCode("Invalid bar-code");
        else if(!barCode.contentEquals("exit")){
            for (Product product : allProducts) {
                if (product.getBarCode().contentEquals(barCode)) {
                    addFoundedProductToReceipt(product);
                    printFoundedProductOnLCD(product);
                    isInDB = true;
                    break;
                }
            }
            if(!isInDB) printNotFoundedProductOnLCDOrInvalidBarCode("Product not found");
        }else receipt.printReceipt();
        isInDB = false;
    }

    private void addFoundedProductToReceipt(Product product) {
        receipt.addProductToReceipt(product);
    }

    public void printFoundedProductOnLCD(Product product) {

        message=new StringBuilder(product.getName());
        message.append(" - ").append(product.getPrice()).append("zł");
        lcdDisplay.setMessageAndPrintOnDisplay(message.toString());
       // System.out.println(message);
    }

    public void printNotFoundedProductOnLCDOrInvalidBarCode(String msg) {

        message=new StringBuilder(msg);
        lcdDisplay.setMessageAndPrintOnDisplay(message.toString());
        // System.out.println(message);
    }

    public StringBuilder getMessage() {
        return message;
    }
}
