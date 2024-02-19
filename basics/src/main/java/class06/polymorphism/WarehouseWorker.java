package class06.polymorphism;

public class WarehouseWorker implements ShippingService {

    @Override
    public int calculateDeliveryTime() {
        return 3; // Some complex business logic goes here ...
    }

    @Override
    public String generateShippingLabel() {
        return "Warehouse standard stamp";
    }
}
