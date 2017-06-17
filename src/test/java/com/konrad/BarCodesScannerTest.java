package com.konrad;

import com.konrad.input.BarCodesScanner;
import com.konrad.model.Product;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


public class BarCodesScannerTest {
    @Mock
    private BarCodesScanner testBarCodesScanner;

    @Mock
    private Receipt receipt;
    
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void scan(){
        testBarCodesScanner = new BarCodesScanner();


        Product productWillFind = createTestProductWillFindInDB();
        testBarCodesScanner.scan(productWillFind.getBarCode());
        Assert.assertEquals("Koło - 29.99zł", testBarCodesScanner.getMessage().toString());

        Product productWillNotFind = createTestProductWillNotFindInDB();
        testBarCodesScanner.scan(productWillNotFind.getBarCode());
        Assert.assertEquals("Product not found", testBarCodesScanner.getMessage().toString());

        testBarCodesScanner.scan("");
        Assert.assertEquals("Invalid bar-code", testBarCodesScanner.getMessage().toString());

        testBarCodesScanner.scan("exit");
        Assert.assertNotEquals(null,receipt);
    }


    private Product createTestProductWillFindInDB() {
        Product product = new Product();
        product.setBarCode("ATW211000");
        product.setName("Koło");
        product.setPrice(29.99);
        return product;
    }

    private Product createTestProductWillNotFindInDB() {
        Product product = new Product();
        product.setBarCode("123456789");
        product.setName("Kłódka");
        product.setPrice(20);
        return product;
    }

}
