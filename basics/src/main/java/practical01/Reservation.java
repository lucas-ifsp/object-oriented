package practical01;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private final String id;
    private final LocalDate checkin;
    private final LocalDate checkout;
    private final Guest guest;
    private final Room room;

    public Reservation(LocalDate checkin, LocalDate checkout, Guest guest, Room room) {
        this.id = ReservationIdGenerator.nextId();
        this.checkin = checkin;
        this.checkout = checkout;
        this.guest = guest;
        this.room = room;
    }

    public double getPrice(){
        final int days = getDays();
        return room.getPrice() * days;
    }

    private int getDays() {
        return Period.between(checkin, checkout).getDays();
    }

    public boolean isReservedAt(LocalDate date, Room room){
        if(this.room.getNumber() != room.getNumber()) return false;
        return !date.isBefore(checkin) && date.isBefore(checkout);
    }

    public String asString(){
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
                        """
                        _______________________________________________________________
                        Reservation: %s Room number: %d
                        Guest name: %s SSN: %s E-mail: %s
                        Check-in: %s Check-out: %s
                        Number of days: %s Room price: U$%.2f
                        TOTAL: U$%.2f;
                        _______________________________________________________________
                        """
                , id, getRoom(), getGuest(), guest.getSsn(), guest.getEmail(), formatter.format(getCheckin())
                , formatter.format(getCheckout()), getDays(), room.getPrice(), getPrice());
    }

    public String getId() {
        return id;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public String getGuest() {
        return guest.getName();
    }

    public int getRoom() {
        return room.getNumber();
    }
}
