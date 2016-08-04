package test.helpers;

import main.checkout.CheckoutRule;
import main.entities.Product;

import java.util.List;

public class KataRule implements CheckoutRule {


    public Integer getDiscount(List<Product> items) {
        Long countA = items.stream().filter(x -> x.getSKU().equals("A")).count();
        Long countB =  items.stream().filter(x -> x.getSKU().equals("B")).count();
        Integer discount = 0;
        discount += (int) (long)countA / 3 * 20;
        discount += (int) (long)countB / 2 * 20;
        return discount;
    }

}
