package class10.transaction;

import class10.basics.Product;
import java.util.Objects;

public class Sale {
    private long id;
    private String seller;
    private int quantity;
    private Product product;

    public Sale(String seller, int quantity, Product product) {
        this.seller = seller;
        this.quantity = quantity;
        this.product = product;
    }

    public Sale(long id, String seller, int quantity, Product product) {
        this.id = id;
        this.seller = seller;
        this.quantity = quantity;
        this.product = product;
    }

    @Override
    public String toString() {
        return String.format("| Sale    | %7d | %-15s | %s | %4d |", id, seller, product.getName(), quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id == sale.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
        return id;
    }

    public String getSeller() {
        return seller;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
