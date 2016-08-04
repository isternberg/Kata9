package main.checkout;

import main.entities.Product;
import main.persistance.MockedDB;

import java.util.ArrayList;
import java.util.List;

public class CheckOut {
    private int total;
    private CheckoutRule rule;
    private List<Product> items;

    public CheckOut(CheckoutRule rule) {
        this.rule = rule;
        total = 0;
        items = new ArrayList<>();

    }

    public void scan(String sku) {
        items.add(MockedDB.getBySku(sku));
    }

    public int total() {
        this.total = items.stream().mapToInt(Product::getPrice).sum();
        int totalWithRule = this.total - rule.getDiscount(items);
        return totalWithRule;
    }
}
