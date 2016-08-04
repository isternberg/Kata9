package test;

import main.entities.Product;
import main.exceptions.NullSKUException;
import main.persistance.MockedDB;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMockedDB {

    @Test
    public void shouldReturnProductBySKU(){
        Product productA = MockedDB.getBySku("A");
        assertEquals("A", productA.getSku());
        assertEquals(40, productA.getPrice());
    }

    @Test(expected = NullSKUException.class)
    public void shouldThrowExceptionIfSKUIsNull(){
        MockedDB.getBySku(null);
    }

    @Test(expected = NullSKUException.class)
    public void shouldThrowExceptionIfSKUIsNull2(){
        String sku = null;
        MockedDB.getBySku(sku);
    }

}
