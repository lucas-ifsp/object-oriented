import class11.withoutdao.Product;

import java.math.BigDecimal;

void main(String[] args) {
    Product product = new Product("SCL0001", "Computer", 2, BigDecimal.valueOf(4532.99));
    product.save();
    product.findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
    product.setPrice(BigDecimal.valueOf(5352.89));
    product.update();
    product.findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
    product.delete("SCL0001");
    product.findOne("SCL0001").ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
}