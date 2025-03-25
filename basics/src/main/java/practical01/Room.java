package practical01;

public class Room {
    private final int number;
    private double price;

    public Room(int number, double price) {
        this.number = number > 0 ? number : 1;
        setPrice(price);
    }

    public void setPrice(double price) {
        this.price = price > 0 ? price : 1.0;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public String asString(){
       return String.format("Room %d: US$ %.2f", number, price);
    }
}
