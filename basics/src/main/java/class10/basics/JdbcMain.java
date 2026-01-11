package class10.basics;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcMain {

    public static final String URL = "jdbc:sqlite:database.db";

    public static void main(String[] args) throws SQLException {
        Product product = new Product("SCL0001 OR '1' == '1'", "Computer", 2, 4532.99);
        //save(product);
        delete("'SCL0001' OR 1=1");
        findAll().stream()
                .map(Product::getSku)
                .forEach(System.out::println);
//        product = new Product("SCL0001", "Notebook", 3, 5352.89);
//        update(product);
//        findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
//        delete("SCL0001");
//        findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
    }

    public static void save(Product product) {
        String sql = "INSERT INTO products (code, name, price, quantity) values (?, ?, ?, ?)";
        try(final var connection = DriverManager.getConnection(URL);
            final var preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, product.getSku());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<Product> findOne(String sku) {
        String sql = "SELECT * FROM products WHERE code = ?";
        try(final Connection connection = DriverManager.getConnection(URL);
            final var preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, sku);
            final ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                return Optional.of(new Product(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public static List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try(final Connection connection = DriverManager.getConnection(URL);
            final var preparedStatement = connection.prepareStatement(sql)
        ) {
            final ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public static void update(Product product) {

    }

    public static void delete(String sku) throws SQLException {
        String sql = "DELETE FROM products WHERE code = " + sku;
        try(final var connection = DriverManager.getConnection(URL);
            final var statement = connection.createStatement()){
            statement.executeUpdate(sql);
        }
    }
}