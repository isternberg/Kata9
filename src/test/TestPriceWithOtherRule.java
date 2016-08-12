package test;

import main.checkout.CheckOut;
import main.checkout.CheckoutRule;
import main.exceptions.ProductNotInDBException;
import org.junit.Before;
import org.junit.Test;
import test.helpers.AnotherRule;

import static org.junit.Assert.assertEquals;


public class TestPriceWithOtherRule extends BaseTest{

    private CheckoutRule rule;

    @Before
    public void setup(){
        rule = new AnotherRule();
    }


    @Test(expected = ProductNotInDBException.class)
    public void shouldThrowExceptionIfNoProductForKey()  {
        CheckOut co = new CheckOut(rule);
        co.scan("SOME WRONG KEY");
    }

    @Test
    public void totals()  {
        assertEquals(0, calculatePrice("", rule));
        assertEquals(20, calculatePrice("D", rule));
        assertEquals(35, calculatePrice("DD", rule));
        assertEquals(55, calculatePrice("DDD", rule));
        assertEquals(95, calculatePrice("ADDD", rule));
    }

    @Test
    public void incremental()  {
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
