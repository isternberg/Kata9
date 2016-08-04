package main.entities;


public class Product {

    public Integer getPrice() {
        return price;
    }

    private String SKU;
    private Integer price; // in productive code this would have to be a BigDecimal

    public Product(String SKU, Integer price) {
        this.SKU = SKU;
        this.price = price;
    }
}
