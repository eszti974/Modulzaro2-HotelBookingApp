package bookingmanagement;

import rooms.KingRoom;
import rooms.StandardRoom;
import rooms.SuperiorRoom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingService implements BookingInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void newBooking(ArrayList<String> bookingData) {
        int roomPrice = 0;
        switch (bookingData.get(4)) {
            case "Standard" -> {
                StandardRoom standardRoom = new StandardRoom();
                if ((bookingData.get(5)).equals("Y")) {
                    standardRoom.isExtraBedNeeded = true;
                }
                roomPrice = standardRoom.calculateRoomPrice();
            }
            case "King" -> {
                KingRoom kingRoom = new KingRoom();
                if ((bookingData.get(5)).equals("Y")) {
                    kingRoom.isExtraBedNeeded = true;
                }
                roomPrice = kingRoom.calculateRoomPrice();
            }
            case "Superior" -> {
                SuperiorRoom superiorRoom = new SuperiorRoom();
                if ((bookingData.get(5)).equals("Y")) {
                    superiorRoom.isExtraBedNeeded = true;
                }
                roomPrice = superiorRoom.calculateRoomPrice();
            }
        }
        int breakfastPrice = 0;
        if ((bookingData.get(2)).equals("Y")) {
            breakfastPrice = 4500;
        }
        int person;
        int days;
        try {
            person = Integer.parseInt(bookingData.get(0));
        } catch (NumberFormatException ex) {
            System.out.println("A személyek számát kérjük számmal adja meg.");
            person = Integer.parseInt(scanner.nextLine());
        }
        try {
            days = Integer.parseInt(bookingData.get(1));
        } catch (NumberFormatException ex) {
            System.out.println("A foglalni kívánt napok számát kérjük számmal adja meg.");
            days = Integer.parseInt(scanner.nextLine());
        }
        Booking booking = new Booking(roomPrice, person, days, bookingData.get(3), breakfastPrice);
        int totalCost = booking.getTotalCost();
        System.out.println(booking.toString() + "Total cost: " + totalCost);

        //A fogalás adatait lementi egy fájlba is, melynek neve: foglalási adatok - aktuális nap.txt. (Pl.: foglalási adatok-2024.01.27.txt)
        try {
            String content = booking.toString() + "Total cost: " + totalCost;
            String fileName = "foglalási adatok-" + LocalDate.now() + ".txt";
            Files.write(Paths.get(fileName), content.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
