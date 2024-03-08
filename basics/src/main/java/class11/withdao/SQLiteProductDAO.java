package class11.withdao;

import java.sql.*;
import java.util.Optional;

public class SQLiteProductDAO implements ProductDAO {

    @Override
    public void save(ProductDTO dto) {
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

    @Override
    public  Optional<ProductDTO> findOne(String sku) {
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

    @Override
    public void update(ProductDTO dto) {
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

    @Override
    public void delete(String sku) {
        String sql = "DELETE FROM products WHERE code = ?";
        try (var statement = ConnectionFactory.getPreparedStatement(sql)) {
            statement.setString(1, sku);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}