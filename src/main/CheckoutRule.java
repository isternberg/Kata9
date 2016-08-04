package main;


import main.entities.Product;

import java.util.Map;

public interface CheckoutRule {

    void apply();

    Map<String, Product> getProductMap();
}
