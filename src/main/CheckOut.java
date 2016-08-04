package main;

public class CheckOut {
    private int total;
    public CheckoutRule rule;

    public CheckOut(CheckoutRule rule) {
        this.rule = rule;
        total = 0;

    }

    public void scan(String sku) {
        if (sku.equals("A"))
            this.total += 40;

    }

    public int total() {
        return total;
    }
}
