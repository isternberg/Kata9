package main;

public class CheckOut {
    private int total;
    public CheckoutRule rule;

    public CheckOut(CheckoutRule rule) {
        this.rule = rule;
        total = 0;

    }

    public void scan(String sku) {
        this.total += rule.getProductMap().get(sku).getPrice();

    }

    public int total() {
        return total;
    }
}
