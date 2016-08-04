package main.checkout;

import main.entities.Product;
import main.exceptions.NullRuleException;
import main.exceptions.NullSKUException;
import main.persistance.MockedDB;
import java.util.ArrayList;
import java.util.List;

public class CheckOut {

    private int total;
    private CheckoutRule rule;
    private List<Product> items;

    public CheckOut(CheckoutRule rule) {
        if (rule == null){
            throw new NullRuleException("The Rule cannot be null");
        }
        this.rule = rule;
        total = 0;
        items = new ArrayList<>();
    }

    public void scan(String sku) throws NullSKUException{
        validateSKU(sku);
        Product product = MockedDB.getBySku(sku);
        items.add(product);
    }

    private void validateSKU(String sku) throws NullSKUException {
        if (sku == null){
            throw new NullSKUException("SKU cannot be null.");
        }
    }

    public int total() {
        this.total = items.stream().mapToInt(Product::getPrice).sum();
        int totalWithRule = this.total - rule.getDiscount(items);
        return totalWithRule;
    }
}
