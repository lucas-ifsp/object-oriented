package practical01;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final Guest guestA = new Guest("045.3423.32.22", "Jão", "jão@pao.com");
        final Guest guestB = new Guest("025.4425.33.12", "Maria", "maria@jao.com");

        Room[] rooms = new Room[]{
                new Room(1, 200.00),
                new Room(2, 300.00),
                new Room(3, 400.00),
                new Room(4, 500.00)
        };

        Hotel hotel = new Hotel("IFSP", rooms);

        final LocalDate today = LocalDate.now();

        final Reservation reservationA = hotel.makeReservation(guestA, 1, today, today.plusDays(3));
        System.out.println(reservationA.asString());

        System.out.println("Overlapping before");
        final Reservation reservationB = hotel.makeReservation(guestB, 1, today.minusDays(1), today.plusDays(2));
        System.out.println(reservationB == null ? "Overbook" : reservationB.asString());

        System.out.println("Overlapping after");
        final Reservation reservationC = hotel.makeReservation(guestB, 1, today.plusDays(1), today.plusDays(5));
        System.out.println(reservationC == null ? "Overbook" : reservationC.asString());

        System.out.println("Overlapping between");
        final Reservation reservationD = hotel.makeReservation(guestB, 1, today.plusDays(1), today.plusDays(2));
        System.out.println(reservationD == null ? "Overbook" : reservationD.asString());

        final Reservation reservation = hotel.cancelReservation(reservationA.getId());
        System.out.println("Cancelling: " + reservation.getId());

        System.out.println("Not overlapping before anymore");
        final Reservation reservationX = hotel.makeReservation(guestB, 1, today.minusDays(1), today.plusDays(2));
        System.out.println(reservationX == null ? "Overbook" : reservationX.asString());

        final Room[] availableRoomsAtToday = hotel.getAvailableRoomsAt(today);
        for (Room room : availableRoomsAtToday) {
            System.out.println(room.asString());
        }

        final Room[] availableRoomsAtNextMonth = hotel.getAvailableRoomsAt(today.plusMonths(1));
        for (Room room : availableRoomsAtNextMonth) {
            System.out.println(room.asString());
        }
    }
}
