package bookingmanagement;

public class Booking {
    private int roomPrice;
    private int person;
    private int days;
    private String bookingName;
    private int breakfastPrice;

    public int getTotalCost() {
        int totalCost = (roomPrice + (breakfastPrice * person)) * days;
        return totalCost;
    }

    ;

    public Booking(int roomPrice, int person, int days, String bookingName, int breakfastPrice) {
        this.roomPrice = roomPrice;
        this.person = person;
        this.days = days;
        this.bookingName = bookingName;
        this.breakfastPrice = breakfastPrice;
    }

    @Override
    public String toString() {
        return "Foglalási adatok: " +
                "szoba ára= " + roomPrice +
                ", személyek száma= " + person +
                ", foglalt napok száma= " + days +
                ", foglalási név= '" + bookingName + '\'' +
                ", reggeli ára/fő/nap= " + breakfastPrice +
                " ";
    }
}
