package test;

import main.checkout.CheckOut;
import main.checkout.CheckoutRule;
import main.exceptions.NullSKUException;
import main.exceptions.ProductNotInDBException;
import org.junit.Before;
import org.junit.Test;
import test.helpers.AnotherRule;

import static org.junit.Assert.assertEquals;


public class TestPriceWithOtherRule {

    private CheckoutRule rule;

    @Before
    public void setup(){
        rule = new AnotherRule();
    }

    private int calculatePrice(String goods) throws NullSKUException {
        CheckOut co = new CheckOut(rule);
        for(int i=0; i<goods.length(); i++) {
            co.scan(String.valueOf(goods.charAt(i)));
        }
        return co.total();
    }

    @Test(expected = ProductNotInDBException.class)
    public void shouldThrowExceptionIfNoProductForKey() throws NullSKUException {
        CheckOut co = new CheckOut(rule);
        co.scan("SOME WRONG KEY");
    }

    @Test(expected = NullSKUException.class)
    public void shouldThrowExceptionIfKeyIsNull() throws NullSKUException {
        CheckOut co = new CheckOut(rule);
        co.scan(null);
    }


    @Test
    public void totals() throws NullSKUException {
        assertEquals(0, calculatePrice(""));
        assertEquals(20, calculatePrice("D"));
        assertEquals(35, calculatePrice("DD"));
        assertEquals(55, calculatePrice("DDD"));
        assertEquals(95, calculatePrice("ADDD"));
    }

    @Test
    public void incremental() throws NullSKUException {
        CheckOut co = new CheckOut(rule);
        assertEquals(0, co.total());
        co.scan("A");
        assertEquals(40, co.total());
        co.scan("D");
        assertEquals(60, co.total());
        co.scan("A");
        assertEquals(100, co.total());
        co.scan("D");
        assertEquals(115, co.total());
        co.scan("D");
        assertEquals(135, co.total());
    }

}
