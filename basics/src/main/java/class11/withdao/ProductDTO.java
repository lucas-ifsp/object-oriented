package class11.withdao;

public record ProductDTO(String code, String name, int quantity, double price) {
    // Records are immutable classes that provide getters, equals, hashcode, and toString by default.
}
