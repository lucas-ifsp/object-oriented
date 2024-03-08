import class10.basics.Product;
import class10.transaction.Sale;

import java.sql.*;
import java.util.Optional;

import static class10.basics.JdbcMain.findOne;
import static class10.basics.JdbcMain.save;

public static void main(String[] args) throws SQLException {
    Product product = new Product("SCL0001", "Computer", 2, 4532.99);
    save(product);
    findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Product not found!"));
    final Sale computer = new Sale("Claude Shannon", 1, product);
    sale(computer);
    findLast().ifPresentOrElse(System.out::println, () -> System.out.println("Sale not found!"));
    findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Product not found!"));
}

public static void sale(Sale sale) throws SQLException {
    final Product product = sale.getProduct();
    final int updatedQuantity = product.getQuantity() - sale.getQuantity();
    product.setQuantity(updatedQuantity);

    String saleSql = "INSERT INTO sales (quantity, seller, product) VALUES (?, ?, ?)";
    String productSql = "UPDATE products SET quantity = ? WHERE code = ?";

    try (Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db")) {
        try (final PreparedStatement saleStatement = connection.prepareStatement(saleSql);
             final PreparedStatement productStatement = connection.prepareStatement(productSql)) {

            connection.setAutoCommit(false);
            saleStatement.setInt(1, sale.getQuantity());
            saleStatement.setString(2, sale.getSeller());
            saleStatement.setString(3, product.getSku());
            saleStatement.executeUpdate();

            productStatement.setInt(11, product.getQuantity()); // used wrong index "by mistake"
            productStatement.setString(2, product.getSku());
            productStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Undoing stuff ...");
            connection.rollback();
        }
    }
}

public static Optional<Sale> findLast() {
    String saleSql = "SELECT * FROM sale ORDER BY id DESC LIMIT 1;";

    try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
         final PreparedStatement saleStatement = connection.prepareStatement(saleSql);
    ) {
        final ResultSet rs = saleStatement.executeQuery();
        if (rs.next()) {
            Product productFk = findOne(rs.getString("product"))
                    .orElseThrow(() -> new SQLException("Could not find product by FK"));
            return Optional.of(new Sale(rs.getInt("id"), rs.getString("seller"), rs.getInt("quantity"), productFk));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Optional.empty();
}