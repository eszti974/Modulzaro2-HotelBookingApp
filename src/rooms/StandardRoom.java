package rooms;

public class StandardRoom extends AbstractRoom {
    @Override
    public int calculateRoomPrice() {
        int standardRoomPrice = getSeasonBasedDefaultPrice();
        if (isExtraBedNeeded) {
            standardRoomPrice = standardRoomPrice + extraBedPrice;
        }
        return standardRoomPrice;
    }
}
