package test;

import main.checkout.CheckOut;
import main.checkout.CheckoutRule;
import org.junit.Before;
import org.junit.Test;
import test.helpers.AnotherRule;
import test.helpers.FixedDiscountRule;

import static org.junit.Assert.assertEquals;

public class TestChainedRule extends BaseTest{

    private CheckoutRule rule;

    @Before
    public void setup(){
        rule = new FixedDiscountRule(new AnotherRule());
    }



    @Test
    public void totals()  {
        assertEquals(-10, calculatePrice("", rule));
        assertEquals(10, calculatePrice("D", rule));
        assertEquals(25, calculatePrice("DD", rule));
        assertEquals(45, calculatePrice("DDD", rule));
        assertEquals(85, calculatePrice("ADDD", rule));
    }

    @Test
    public void incremental()  {
        CheckOut co = new CheckOut(rule);
        assertEquals(-10, co.total());
        co.scan("A");
        assertEquals(30, co.total());
        co.scan("D");
        assertEquals(50, co.total());
        co.scan("A");
        assertEquals(90, co.total());
        co.scan("D");
        assertEquals(105, co.total());
        co.scan("D");
        assertEquals(125, co.total());
    }
}
