public class RoomSystemTest {
    public static void main(String[] args) {
        RoomService<Room> roomService = new SimpleRoomService<>();

        EconomyRoom economyRoom = new EconomyRoom(101);
        StandardRoom standardRoom = new StandardRoom(201);
        LuxRoom luxRoom = new LuxRoom(301);
        UltraLuxRoom ultraLuxRoom = new UltraLuxRoom(401);

        testRoomService(roomService, economyRoom);
        testRoomService(roomService, standardRoom);
        testRoomService(roomService, luxRoom);
        testRoomService(roomService, ultraLuxRoom);
    }

    private static void testRoomService(RoomService<Room> service, Room room) {
        System.out.println("\nТестируем комнату №" + room.getRoomNumber() + " (" + room.getClass().getSimpleName() + ")");

        service.clean(room);
        service.reserve(room);

        try {
            service.reserve(room);
        } catch (RoomAlreadyBookedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        service.free(room);
        service.reserve(room);
    }
}