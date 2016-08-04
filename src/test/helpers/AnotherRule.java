package test.helpers;

import main.CheckoutRule;
import main.entities.Product;

import java.util.List;

public class AnotherRule implements CheckoutRule{
    public Integer getDiscount(List<Product> items) {
        Long countD = items.stream().filter(x -> x.getSKU().equals("D")).count();
        Integer discount = 0;
        discount += (int) (long)countD / 2 * 5;
        return discount;
    }
}
