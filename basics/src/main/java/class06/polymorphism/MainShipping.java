import class06.polymorphism.DeliveryDriver;
import class06.polymorphism.ShippingService;
import class06.polymorphism.WarehouseWorker;

void main(){
    WarehouseWorker someWarehouse = new WarehouseWorker(); // less flexible
    ShippingService warehouse = new WarehouseWorker(); // more flexible
    DeliveryDriver delivery = new DeliveryDriver();

    System.out.println(warehouse.calculateDeliveryTime()); // 3
    System.out.println(warehouse.generateShippingLabel()); // Warehouse standard stamp
    // Static method of the interface. No need of concrete instance.
    System.out.println(ShippingService.generateShipmentLog()); // [29-01-2024] Product has been shipped.

    ShippingService[] shippingChain = {someWarehouse, warehouse, delivery};
    int totalDeliveryTime = 0;
    for (ShippingService service : shippingChain) {
        final int deliveryTime = service.calculateDeliveryTime();
        System.out.println(STR."Delivery time of \{service.getClass().getSimpleName()} = \{deliveryTime} days.");
        totalDeliveryTime += deliveryTime;
    }
    System.out.println("totalDeliveryTime = " + totalDeliveryTime);

    for (ShippingService service : shippingChain) {
        System.out.println("service.generateShippingLabel() = " + service.generateShippingLabel()); // interface method
        if(service instanceof DeliveryDriver deliveryElement) { // creates the temporary variable deliveryElement if service is of type DeliveryDriver
            final boolean isDelivered = deliveryElement.confirmationCode("43"); // cast is necessary to access subclass methods - la garantia soy yo
            System.out.println("isDelivered = " + isDelivered);
        }
    }
}