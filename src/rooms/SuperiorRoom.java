package rooms;

public class SuperiorRoom extends AbstractRoom {
    protected int additionalRoomPrice = 3500;

    @Override
    public int calculateRoomPrice() {
        int superiorRoomPrice = getSeasonBasedDefaultPrice() + additionalRoomPrice;
        if (isExtraBedNeeded) {
            superiorRoomPrice = superiorRoomPrice + extraBedPrice;
        }
        return superiorRoomPrice;
    }
}
