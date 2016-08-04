package test;

import main.checkout.CheckOut;
import main.checkout.CheckoutRule;
import main.exceptions.BadSKUException;
import main.exceptions.NullRuleException;
import org.junit.Test;
import test.helpers.AnotherRule;

public class CheckoutTests {

    public static final String EMPTY_SKU = "";

    @Test(expected = NullRuleException.class)
    public void shouldThrowExceptionIfRuleIsSetToNull(){
        CheckOut checkOut = new CheckOut(null);
        checkOut.total();
    }

    @Test(expected = BadSKUException.class)
    public void shouldThrowExceptionIfSKUisEmptyString (){
        CheckoutRule checkoutRule = new AnotherRule();
        CheckOut checkOut = new CheckOut(checkoutRule);
        checkOut.scan(EMPTY_SKU);
    }

    @Test(expected = BadSKUException.class)
    public void shouldThrowExceptionIfKeyIsNull() {
        CheckoutRule checkoutRule = new AnotherRule();
        CheckOut co = new CheckOut(checkoutRule);
        co.scan(null);
    }

}
