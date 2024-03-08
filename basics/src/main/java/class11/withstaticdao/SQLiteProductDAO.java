package class11.withstaticdao;

import class11.withdao.ConnectionFactory;
import class11.withdao.ProductDAO;
import class11.withdao.ProductDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLiteProductDAO  {
    public static void save(ProductDTO dto) {
        String sql = "INSERT INTO products (code, name, price, quantity) VALUES (?, ?, ?, ?)";

        try (var statement = ConnectionFactory.getPreparedStatement(sql)) {
            statement.setString(1, dto.code());
            statement.setString(2, dto.name());
            statement.setDouble(3, dto.price());
            statement.setInt(4, dto.quantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Optional<ProductDTO> findOne(String sku) {
        String sql = "SELECT * FROM products WHERE code = ?";

        try (var statement = ConnectionFactory.getPreparedStatement(sql)) {
            statement.setString(1, sku);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Optional.of(new ProductDTO(
                        rs.getString("code"), rs.getString("name"),
                        rs.getInt("quantity"), rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static void update(ProductDTO dto) {
        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE code = ?";
        try (var statement = ConnectionFactory.getPreparedStatement(sql)) {
            statement.setString(1, dto.name());
            statement.setDouble(2, dto.price());
            statement.setInt(3, dto.quantity());
            statement.setString(4, dto.code());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String sku) {
        String sql = "DELETE FROM products WHERE code = ?";
        try (var statement = ConnectionFactory.getPreparedStatement(sql)) {
            statement.setString(1, sku);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}