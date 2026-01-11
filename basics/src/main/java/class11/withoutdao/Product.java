package class11.withoutdao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Objects;
import java.util.Optional;

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

    public BigDecimal getTotal() {
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

    public void save() {
        String sql = "INSERT INTO products (code, name, price, quantity) VALUES (?, ?, ?, ?)";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sku);
            statement.setString(2, name);
            statement.setDouble(3, price.doubleValue());
            statement.setInt(4, quantity);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Product> findOne(String sku) {
        String sql = "SELECT * FROM products WHERE code = ?";

        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sku);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Optional.of(new Product(
                        rs.getString("code"), rs.getString("name"),
                        rs.getInt("quantity"), BigDecimal.valueOf(rs.getDouble("price"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void update() {
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE code = ?";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setDouble(2, price.doubleValue());
            statement.setInt(3, quantity);
            statement.setString(4, sku);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String sku) {
        String sql = "DELETE FROM products WHERE code = ?";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sku);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
