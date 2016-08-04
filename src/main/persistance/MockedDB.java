package main.persistance;

import main.entities.Product;
import main.exceptions.NullSKUException;
import main.exceptions.ProductNotInDBException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MockedDB {

    private static List<Product> products = Arrays.asList(new Product("A", 40), new Product("B", 50),
            new Product("C", 25), new Product("D", 20));

    public static Product getBySku(String sku) {
        Map<String, Product> productMap =
                products.stream().collect(Collectors.toMap(Product::getSku, p -> p));

        handleInvalidSKU(sku, productMap);
        return productMap.get(sku);
    }

    private static void handleInvalidSKU(String sku, Map<String, Product> productMap) {
        if (sku == null){
            throw new NullSKUException("SKU cannot be null.");
        }
        if (productMap.get(sku) == null ){
            throw new ProductNotInDBException
                    ("Product with SKU " + sku + " could not be found.");
        }
    }
}
