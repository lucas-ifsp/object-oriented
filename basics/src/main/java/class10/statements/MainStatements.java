import class10.basics.JdbcMain;
import class10.basics.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public static void main(String[] args) {
    final List<Product> products = List.of(
            new Product("SCL0001", "Computer", 2, 4532.99),
            new Product("SCL0002", "Mouse", 12, 32.34),
            new Product("SCL0003", "Keyboard", 3, 122.99)
    );
    products.forEach(JdbcMain::save);
    delete("'SCL0001' OR 1 = 1"); // SQL Injection
    findAll().forEach(System.out::println);
}

public static void delete(String sku) {
    // add parameter validation here ...
    String sql = "DELETE FROM products WHERE code = " + sku;

    try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
         final Statement statement = connection.createStatement()) {
        statement.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static List<Product> findAll() {
    List<Product> result = new ArrayList<>();
    String sql = "SELECT * FROM products";

    try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
         final PreparedStatement statement = connection.prepareStatement(sql)
    ) {
        final ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            result.add(new Product(rs.getString("code"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return result;
}

