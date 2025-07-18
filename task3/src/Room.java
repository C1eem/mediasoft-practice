public abstract class Room {
    private int roomNumber;
    private int maxPeople;
    private int pricePerNight;
    private boolean isBooked;

    protected Room(int roomNumber, int maxPeople, int pricePerNight){
        this.roomNumber = roomNumber;
        this.maxPeople = maxPeople;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
