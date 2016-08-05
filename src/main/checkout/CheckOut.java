package main.checkout;

import main.entities.Product;
import main.exceptions.NullRuleException;
import main.exceptions.BadSKUException;
import main.persistance.MockedDB;
import java.util.ArrayList;
import java.util.List;

public class CheckOut {

    private int total;
    private CheckoutRule rule;
    private List<Product> items;

    public CheckOut(CheckoutRule rule) {
        handleInvalidRules(rule);

        this.rule = rule;
        total = 0;
        items = new ArrayList<>();
    }

    private void handleInvalidRules(CheckoutRule rule) {
        if (rule == null){
            throw new NullRuleException("The Rule cannot be null.");
        }
    }

    public void scan(String sku) {
        validateSKU(sku);
        Product product = MockedDB.getBySku(sku);
        items.add(product);
    }

    private void validateSKU(String sku) {
        if (sku == null){
            throw new BadSKUException("SKU cannot be null.");
        }
        if (sku.equals("")){
            throw new BadSKUException("SKU cannot be empty.");
        }
    }

    public int total() {
        this.total = items.stream().mapToInt(Product::getPrice).sum();
        int totalWithRule = this.total - rule.getDiscount(items);
        return totalWithRule;
    }
}
