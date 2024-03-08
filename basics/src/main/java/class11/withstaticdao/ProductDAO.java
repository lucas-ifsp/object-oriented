package class11.withstaticdao;

import class11.withdao.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    void save(ProductDTO dto);
    Optional<ProductDTO> findOne(String sku);
    List<ProductDTO> findAll();
    void update(ProductDTO dto);
    void delete(String sku);
}
