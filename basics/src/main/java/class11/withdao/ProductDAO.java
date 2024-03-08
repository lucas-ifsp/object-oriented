package class11.withdao;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    void save(ProductDTO dto);
    Optional<ProductDTO> findOne(String sku);
    void update(ProductDTO dto);
    void delete(String sku);
}
