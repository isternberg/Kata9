package main.checkout;


import main.entities.Product;

import java.util.List;

@FunctionalInterface
public interface CheckoutRule {

    int getDiscount(List<Product> items);

}
