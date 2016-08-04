package test.helpers;

import main.checkout.CheckoutRule;
import main.entities.Product;

import java.util.List;

public class AnotherRule implements CheckoutRule{

    public int getDiscount(List<Product> items) {
        Long countD = items.stream().filter(x -> x.getSku().equals("D")).count();
        int discount = 0;
        discount += (int) (long)countD / 2 * 5;
        return discount;
    }
}
