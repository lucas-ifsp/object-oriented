package practical01;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Hotel {
    private final String name;
    private final Room[] rooms;
    private final Reservation[] reservations;
    private int reservationsCount;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
        this.reservations = new Reservation[100];
    }

    public Reservation makeReservation(Guest guest, int roomNumber, LocalDate checkin, LocalDate checkout) {
        final Room room = getRoom(roomNumber);
        if(room == null) return null;
        if(isInvalidDateRange(checkin, checkout)) return null;
        if(!isAvailableAt(room, checkin, checkout)) return null;

        final Reservation reservation = new Reservation(checkin, checkout, guest, room);
        reservations[reservationsCount++] = reservation;

        return reservation;
    }

    public Reservation cancelReservation(String id){
        for (int i = 0; i < reservationsCount; i++) {
            Reservation reservation = reservations[i];
            if(reservation.getId().equals(id)){
                reservations[i] = null;
                return reservation;
            }
        }
        return null;
    }

    public Room[] getAvailableRoomsAt(LocalDate date) {
        Room[] reservedRooms = new Room[rooms.length];
        int reservedRoomIndex = 0;

        for (Room room : rooms) {
            for (int i = 0; i < reservationsCount; i++) {
                Reservation reservation = reservations[i];
                if(reservation == null) continue;
                if(reservation.isReservedAt(date, room)){
                    reservedRooms[reservedRoomIndex++] = room;
                    break;
                }
            }
        }
        int availableRoomSize = rooms.length - reservedRoomIndex;
        Room[] availableRooms = new Room[availableRoomSize];
        int availableRoomIndex = 0;

        for (Room room : rooms) {
            boolean contains = false;
            for (Room reservedRoom : reservedRooms) {
                if(reservedRoom == null) continue;
                if(room.getNumber() == reservedRoom.getNumber()) {
                    contains = true;
                    break;
                }
            }
            if(!contains) availableRooms[availableRoomIndex++] = room;
        }

        return availableRooms;
    }

    private static boolean isInvalidDateRange(LocalDate checkin, LocalDate checkout) {
        return checkin == null || checkout == null || !checkin.isBefore(checkout);
    }

    private Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if(room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private boolean isAvailableAt(Room room, LocalDate checkIn, LocalDate checkOut) {
        final boolean hasRoom = hasRoom(room);
        if(!hasRoom) return false;

        for (int i = 0; i < reservationsCount; i++) {
            Reservation reservation = reservations[i];
            if(reservation != null && reservation.getRoom() == room.getNumber()){
                if (isReservedInRange(room, checkIn, checkOut, reservation)) return false;
            }
        }
        return true;
    }

    private static boolean isReservedInRange(Room room, LocalDate checkIn, LocalDate checkOut, Reservation reservation) {
        LocalDate current = checkIn;
        while(current.isBefore(checkOut)){
            if(reservation.isReservedAt(current, room)){
                return true;
            }
            current = current.plusDays(1);
        }
        return false;
    }

    private boolean hasRoom(Room room) {
        for (Room r : rooms) {
            if(r.getNumber() == room.getNumber()) return true;
        }
        return false;
    }


}
