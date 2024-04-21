package rooms;

import java.time.LocalDate;

public abstract class AbstractRoom {
    public boolean isExtraBedNeeded = false;
    public int extraBedPrice = 3000;
    protected int seasonBasedPrice;

    public int getSeasonBasedDefaultPrice() {
        int monthNow = (LocalDate.now()).getMonthValue();
        if (monthNow >= 3 && monthNow <= 5) {
            seasonBasedPrice = 11000;
        } else if (monthNow >= 6 && monthNow <= 8) {
            seasonBasedPrice = 21000;
        } else if (monthNow >= 9 && monthNow <= 11) {
            seasonBasedPrice = 15000;
        } else {
            seasonBasedPrice = 11000;
        }
        return seasonBasedPrice;
    }

    public abstract int calculateRoomPrice();
}
