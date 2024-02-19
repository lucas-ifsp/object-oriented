package class06.polymorphism;

public class DeliveryDriver implements ShippingService{

    @Override
    public int calculateDeliveryTime() {
        return 1; // Some complex business logic goes here ...
    }

    @Override
    public String generateShippingLabel() {
        return "Delivery company stamp";
    }

    // Subclass method
    public boolean confirmationCode(String code){
        return code.equals("43"); // Some complex business logic goes here ...
    }
}
