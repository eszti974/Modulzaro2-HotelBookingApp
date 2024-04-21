import bookingmanagement.BookingService;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelBookingApp {
    public static void main(String[] args) {
        ArrayList<String> bookingData = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hány főre foglal?");
        bookingData.add(scanner.nextLine());
        System.out.println("Hány napot maradnak?");
        bookingData.add(scanner.nextLine());
        System.out.println("Reggelit kérnek-e? Y(igen) vagy N(nem)");
        bookingData.add(scanner.nextLine());
        System.out.println("Milyen néven rögzíthető a foglalás?");
        bookingData.add(scanner.nextLine());
        System.out.println("Milyen szobát szeretne? King, Superior vagy Standard?");
        bookingData.add(scanner.nextLine());
        System.out.println("Pótágyra szükség van? Y(igen) vagy N(nem)");
        bookingData.add(scanner.nextLine());

        BookingService bookingService = new BookingService();
        bookingService.newBooking(bookingData);


    }
}