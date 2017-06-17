package com.konrad;

import com.konrad.input.BarCodesScanner;

public class Main {

    public static void main(String[] args) {

        BarCodesScanner barCodesScanner= new BarCodesScanner();
        String[] in = new String[6];
        in[0] = "";
        in[1] = "13148141919";
        in[2] = "232419992";
        in[3] = "211111112";
        in[4] = "023141222";
        in[5] = "exit";
        for (int i = 0; i <in.length ; i++) {
            barCodesScanner.scan(in[i]);
        }
    }
}
