import class11.withdao.Product;
import class11.withdao.ProductDTO;
import class11.withstaticdao.SQLiteProductDAO;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

void main() {updatePrice("SCL0001", 1_000.0);}

void updatePrice(String sku, double incrementValue) {
    final Product product = SQLiteProductDAO.findOne(sku).map(this::fromDto)
            .orElseThrow(() -> new NoSuchElementException("Product not found: " + sku));

    product.setPrice(product.getPrice().add(BigDecimal.valueOf(incrementValue)));
    SQLiteProductDAO.update(toDto(product));
}

public ProductDTO toDto(Product product) {
    return new ProductDTO(product.getSku(), product.getName(), product.getQuantity(), product.getPrice().doubleValue());
}

public Product fromDto(ProductDTO dto) {
    return new Product(dto.code(), dto.name(), dto.quantity(), BigDecimal.valueOf(dto.price()));
}

