package main.entities;


import main.exceptions.BadSKUException;

public class Product {

    public Product(String sku, int price) {
        if (sku == null){
            throw new BadSKUException("Product cannot have null as SKU.");
        }
        this.sku = sku;
        this.price = price;
    }

    private String sku;

    private int price; // in productive code this would have to be a BigDecimal

    public int getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }
}
