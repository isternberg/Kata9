package main;


import main.entities.Product;

import java.util.List;

public interface CheckoutRule {

    Integer getDiscount(List<Product> items);

}
