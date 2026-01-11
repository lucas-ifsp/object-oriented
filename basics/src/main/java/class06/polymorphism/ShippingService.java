package class06.polymorphism;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface ShippingService {
    int calculateDeliveryTime();
    String generateShippingLabel();
    static String generateShipmentLog(){
        return "["+ createTimestamp() + "] Product has been shipped.";
    }
    private static String createTimestamp(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
