package temp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        //main.save(new Product("Pablo Vittar", "Aii papaiii ...", 69, 1234));
        main.findAll().forEach(System.out::println);
    }

    public void save(Product product) {
        String sql = """
                INSERT INTO
                    products (code, name, price, quantity)
                VALUES
                    (?, ?, ?, ?)
                """;
        try (var conn = DriverManager.getConnection("jdbc:sqlite:tusca.db");
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getSku());
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException _) {
            System.err.println("Corre que pai loko");
        }
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:tusca.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            final ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                final String code = rs.getString("code");
                final String name = rs.getString("name");
                final double price = rs.getDouble("price");
                final int quantity = rs.getInt("quantity");
                products.add(new Product(code, name, quantity, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}




