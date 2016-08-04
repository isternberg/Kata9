package test;

import main.checkout.CheckOut;
import main.exceptions.NullRuleException;
import org.junit.Test;

public class CheckoutTests {

    @Test(expected = NullRuleException.class)
    public void shouldThrowExceptionIfRuleIsSetToNull(){
        CheckOut checkOut = new CheckOut(null);
        checkOut.total();
    }

}
