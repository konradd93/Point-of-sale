package com.konrad;

import com.konrad.dao.ProductDao;
import com.konrad.model.Product;
import com.konrad.service.ProductService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;


public class ProductServiceTest {
    @Mock
    private ProductDao productDao;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void testFindById(){
        MockitoAnnotations.initMocks(this);
        ProductService productService = new ProductService(productDao);
        productService.findById(1L);
        Mockito.verify(productDao).findById(1L);
    }

    @Test
    public void test(){
        ProductService productService = new ProductService(productDao);
        Mockito.when(productDao.findById(1L)).thenReturn(createTestEntity());
        Product actual = productService.findById(1L);
        Assert.assertEquals("ATW211000", actual.getBarCode());
        Assert.assertEquals("Koło", actual.getName());
        Assert.assertEquals(20, actual.getPrice(),0);
        Mockito.verify(productDao).findById(1L);
    }

    private Product createTestEntity() {
        Product product = new Product();
        product.setBarCode("ATW211000");
        product.setName("Koło");
        product.setPrice(20);
        return product;
    }

    @Test
    public void findAll()
    {
        Mockito.when(productDao.findAll()).thenReturn(new ArrayList<Product>());

        List<Product> products = productDao.findAll();
        Assert.assertNotNull(products);
        Assert.assertEquals(0, products.size());
        Mockito.verify(productDao, Mockito.times(1)).findAll();

    }

}
