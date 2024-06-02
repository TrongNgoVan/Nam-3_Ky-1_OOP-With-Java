import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.text.*;

public class J07046_Danh_sach_luu_tru {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Khach> khach = new ArrayList<>();
        for (int i = 1; i <= t; i++) {
            khach.add(new Khach(i, sc.nextLine(), sc.nextLine(), new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()), new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine())));
        }
        khach.sort((a, b) -> (int)(b.getDays() - a.getDays()));
        khach.forEach(System.out::println);
    }
}

class Khach {
    String id, name, room;
    Date arrivalDate, departureDate;


    public Khach(int id, String name, String room, Date arrivalDate, Date departureDate) {
        this.id = "KH" + String.format("%02d", id);
        this.name = name;
        this.room = room;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public long getDays () {
        return TimeUnit.MILLISECONDS.toDays(departureDate.getTime() - arrivalDate.getTime());
    }

    @Override
    public String toString() {
        return id + " " + name + " " + room + " " + getDays();
    }

}