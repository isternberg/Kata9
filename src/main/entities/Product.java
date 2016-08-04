package main.entities;

import lombok.Getter;

public class Product {

    @Getter  private String SKU;
    @Getter private Integer price; // in productive code this would have to be a BigDecimal

    public Product(String SKU, Integer price) {
        this.SKU = SKU;
        this.price = price;
    }
}
