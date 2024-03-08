package class10.basics;

import java.sql.*;
import java.util.Optional;

public class JdbcMain {
    public static void main(String[] args) {
        Product product = new Product("SCL0001", "Computer", 2, 4532.99);
        save(product);
        findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
        product = new Product("SCL0001", "Notebook", 3, 5352.89);
        update(product);
        findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
        delete("SCL0001");
        findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
    }

    public static void save(Product product) {
        // add parameter validation here ...
        String sql = "INSERT INTO products (code, name, price, quantity) VALUES (?, ?, ?, ?)";

        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db"); final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getSku());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Optional<Product> findOne(String sku) {
        // add parameter validation here ...
        String sql = "SELECT * FROM products WHERE code = ?";

        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sku);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Optional.of(new Product(
                        rs.getString("code"), rs.getString("name"),
                        rs.getInt("quantity"), rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static void update(Product product) {
        // add parameter validation here ...
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE code = ?";
        // for mysql, use jdbc:mysql://<ip_address>:/<db_name>",  "<user>", "<pwd>" "
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getSku());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String sku) {
        // add parameter validation here ...
        String sql = "DELETE FROM products WHERE code = ?";

        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db"); final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sku);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}