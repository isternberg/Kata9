package main.persistance;

import main.entities.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockedDB {

    private static List<Product> products = Arrays.asList(new Product("A", 40), new Product("B", 50),
            new Product("C", 25), new Product("D", 20));

    public static Product getBySku(String sku) {
        Map<String, Product> productMap =
                products.stream().collect(Collectors.toMap(Product::getSKU, p-> p));
        return productMap.get(sku);
    }
}
