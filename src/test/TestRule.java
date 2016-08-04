package test;

import main.CheckoutRule;
import main.entities.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestRule implements CheckoutRule {

    private Map<String, Product> productMap;

    public TestRule(List<Product> products) {
        productMap = new HashMap<>();
        productMap =products.stream().collect(Collectors.toMap(Product::getSKU, p-> p));
    }

    @Override
    public void apply() {

    }

    @Override
    public Map<String, Product> getProductMap() {
        return productMap;
    }
}
