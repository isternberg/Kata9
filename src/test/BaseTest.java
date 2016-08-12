package test;

import main.checkout.CheckOut;
import main.checkout.CheckoutRule;

public class BaseTest {



    protected int calculatePrice(String goods, CheckoutRule rule) {
        CheckOut co = new CheckOut(rule);
        for(int i=0; i<goods.length(); i++) {
            co.scan(String.valueOf(goods.charAt(i)));
        }
        return co.total();
    }
}
