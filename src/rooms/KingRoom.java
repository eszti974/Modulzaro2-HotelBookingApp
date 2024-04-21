package rooms;

public class KingRoom extends AbstractRoom {
    protected int additionalRoomPrice = 11000;

    @Override
    public int calculateRoomPrice() {
        int kingRoomPrice = getSeasonBasedDefaultPrice() + additionalRoomPrice;
        if (isExtraBedNeeded) {
            kingRoomPrice = kingRoomPrice + extraBedPrice;
        }
        return kingRoomPrice;
    }
}
