package test;

import main.checkout.CheckOut;
import main.checkout.CheckoutRule;
import org.junit.Before;
import org.junit.Test;
import test.helpers.KataRule;

import static org.junit.Assert.assertEquals;



public class TestPrice extends BaseTest{

    private CheckoutRule rule;

    @Before
    public void setup(){
        rule = new KataRule();
    }

    @Test
    public void totals()  {
        assertEquals(0, calculatePrice("", rule));
        assertEquals(40, calculatePrice("A", rule));
        assertEquals(90, calculatePrice("AB", rule));
        assertEquals(135, calculatePrice("CDBA", rule));

        assertEquals(80, calculatePrice("AA",rule));
        assertEquals(100, calculatePrice("AAA", rule));
        assertEquals(140, calculatePrice("AAAA", rule));
        assertEquals(180, calculatePrice("AAAAA", rule));
        assertEquals(200, calculatePrice("AAAAAA", rule));

        assertEquals(150, calculatePrice("AAAB", rule));
        assertEquals(180, calculatePrice("AAABB", rule));
        assertEquals(200, calculatePrice("AAABBD", rule));
        assertEquals(200, calculatePrice("DABABA", rule));
    }

    @Test
    public void incremental()  {
        CheckOut co = new CheckOut(rule);
        assertEquals(0, co.total());
        co.scan("A");
        assertEquals(40, co.total());
        co.scan("B");
        assertEquals(90, co.total());
        co.scan("A");
        assertEquals(130, co.total());
        co.scan("A");
        assertEquals(150, co.total());
        co.scan("B");
        assertEquals(180, co.total());
    }
}
