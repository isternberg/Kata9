package test;

import main.CheckOut;
import main.CheckoutRule;
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

    public int calculatePrice(String goods) {
        CheckOut co = new CheckOut(rule);
        for(int i=0; i<goods.length(); i++) {
            co.scan(String.valueOf(goods.charAt(i)));
        }
        return co.total();
    }
    @Test
    public void totals() {
        assertEquals(0, calculatePrice(""));
        assertEquals(20, calculatePrice("D"));
        assertEquals(35, calculatePrice("DD"));
        assertEquals(55, calculatePrice("DDD"));
        assertEquals(95, calculatePrice("ADDD"));


    }

    @Test
    public void incremental() {
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
