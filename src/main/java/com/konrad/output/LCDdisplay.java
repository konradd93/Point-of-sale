package com.konrad.output;

public class LCDdisplay {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessageAndPrintOnDisplay(String message) {
        this.message = message;
        printOnDisplay();
    }

    void printOnDisplay(){
        System.out.print("LCD: ");
        System.out.println(message);
    }
}
