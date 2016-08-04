package test.helpers;

import main.checkout.CheckoutRule;
import main.entities.Product;

import java.util.List;

public class KataRule implements CheckoutRule {


    public int getDiscount(List<Product> items) {
        Long countA = items.stream().filter(x -> x.getSku().equals("A")).count();
        Long countB =  items.stream().filter(x -> x.getSku().equals("B")).count();
        int discount = 0;
        discount += (int) (long)countA / 3 * 20;
        discount += (int) (long)countB / 2 * 20;
        return discount;
    }

}
