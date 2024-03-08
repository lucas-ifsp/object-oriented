

import class11.withdao.Product;
import class11.withdao.ProductDAO;
import class11.withdao.ProductDTO;
import class11.withdao.SQLiteProductDAO;

import java.math.BigDecimal;

void main() {
    Product product = new Product("SCL0001", "Computer", 2, BigDecimal.valueOf(4532.99));
    ProductDAO dao = new SQLiteProductDAO();
    dao.save(toDto(product));
    dao.findOne("SCL0001").map(this::fromDto).ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
    product.setPrice(BigDecimal.valueOf(5352.89));
    dao.update(toDto(product));
    dao.findOne("SCL0001").map(this::fromDto).ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
    dao.delete("SCL0001");
    dao.findOne("SCL0001").map(this::fromDto).ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
}

public ProductDTO toDto(Product product) {
    return new ProductDTO(product.getSku(), product.getName(), product.getQuantity(), product.getPrice().doubleValue());
}

public Product fromDto(ProductDTO dto){
    return new Product(dto.code(), dto.name(), dto.quantity(), BigDecimal.valueOf(dto.price()));
}

