import java.text.*;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class J07047_Quan_ly_khach_san {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt();
        ArrayList<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(new Room(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble()));
        }

        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = sc.nextLine(), roomId = sc.nextLine();
            Room room = new Room();
            for (Room r : rooms)
                if (r.getId().equals(roomId.substring(2, 3))) {
                    room = r;
                    break;
                }
            clients.add(new Client(i + 1, name, roomId, sc.nextLine(), sc.nextLine(), room));
        }

        clients.sort((a, b) -> {
            try {
                return b.getDays() > a.getDays() ? 1 : -1;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
        clients.forEach(System.out::println);
    }
}

class Room {
    private String id, name;
    private double price, serveFee;

    public Room() {
    }

    public Room(String id, String name, double price, double serveFee) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.serveFee = serveFee;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getServeFee() {
        return serveFee;
    }
}

class Client {
    private String id, name, roomId, arriveDate, departureDate;
    private Room room;
    private long days;

    public Client(int id, String name, String roomId, String arriveDate, String departureDate, Room room)
            throws ParseException {
        this.id = String.format("KH%02d", id);
        this.name = name;
        this.roomId = roomId;
        this.arriveDate = arriveDate;
        this.departureDate = departureDate;
        this.room = room;
        this.days = getDays();
    }

    public long getDays() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        long time = sdf.parse(departureDate).getTime() - sdf.parse(arriveDate).getTime();
        return days = TimeUnit.MILLISECONDS.toDays(time);
    }

    private int getDiscount() {
        if (days >= 30)
            return 6;
        if (days >= 20)
            return 4;
        if (days >= 10)
            return 2;
        return 0;
    }

    private double getTotalFee() {
        long days = this.days > 0 ? this.days : 1;
        return days * 1.0 * room.getPrice() * (room.getServeFee() + 1) * (100 - getDiscount()) / 100;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %.2f", id, name, roomId, days, getTotalFee());
    }
}