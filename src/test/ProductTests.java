package test;

import main.entities.Product;
import main.exceptions.BadSKUException;
import org.junit.Test;

public class ProductTests {

    public static final int VALID_PRICE = 42;

    @Test(expected = BadSKUException.class)
    public void shouldThrowExceptionIfInitializedWithNullSKU(){
        Product product = new Product(null, VALID_PRICE);
    }
}
