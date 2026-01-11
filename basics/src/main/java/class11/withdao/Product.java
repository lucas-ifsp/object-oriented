package class11.withdao;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String sku;
    private String name;
    private int quantity;
    private BigDecimal price;

    public Product(String sku, String name, int quantity, BigDecimal price) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public BigDecimal getTotal(){
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public String getSku() {
        return sku;
    }

    @Override
    public String toString() {
        return String.format("| Product | %s | %-15s | %8.2f | %4d | %10.2f |", sku, name, price, quantity, getTotal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
