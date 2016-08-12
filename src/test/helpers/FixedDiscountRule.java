package test.helpers;

import main.checkout.CheckoutRule;
import main.entities.Product;

import java.util.List;

public class FixedDiscountRule implements CheckoutRule {

    private static final int FIXED_DISCOUNT = 10;
    CheckoutRule containedRule;

    public FixedDiscountRule(CheckoutRule containedRule ) {
        this.containedRule = containedRule;
    }

    @Override
    public int getDiscount(List<Product> items) {
        return containedRule.getDiscount(items) + FIXED_DISCOUNT;
    }
}
