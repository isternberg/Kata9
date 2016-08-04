package test;

import main.entities.Product;
import main.persistance.MockedDB;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMockedDB {

    @Test
    public void shouldReturnProductBySKU(){
        Product productA = MockedDB.getBySku("A");
        assertEquals("A", productA.getSKU());
        assertEquals(Integer.valueOf(40), productA.getPrice());
    }

}
