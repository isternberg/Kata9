package test;

import main.entities.Product;
import main.exceptions.NullSKUException;
import org.junit.Test;

public class ProductTests {

    public static final int VALID_PRICE = 42;

    @Test(expected = NullSKUException.class)
    public void shouldThrowExceptionIfInitializedWithNullSKU(){
        Product product = new Product(null, VALID_PRICE);
    }
}
