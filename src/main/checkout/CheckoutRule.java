package main.checkout;


import main.entities.Product;

import java.util.List;

public interface CheckoutRule {

    int getDiscount(List<Product> items);

}
