import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.text.*;

public class J07051_Tinh_tien_phong {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KH> kh = new ArrayList<>();
        for (int i = 1; i <= n; i++) 
            kh.add(new KH(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        kh.sort((a, b) -> (int)(b.getPayment() - a.getPayment()));
        kh.forEach(System.out::println);
    }
}

class KH {
    String name, room, id;
    Date arrivalDate, departureDate;
    Integer service;

    public KH(int i, String name, String room, String arrivalDate, String departureDate, Integer service) throws ParseException {
        this.name = name;
        this.room = room;
        this.arrivalDate = toDate(arrivalDate);
        this.departureDate = toDate(departureDate);
        this.service = service;
        this.id = String.format("KH%02d", i);
        formatName(name);
    }

    public void formatName(String name) {
        String[] list = name.trim().split("\\s+");
        for (int i = 0; i < list.length; i++)
            list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1).toLowerCase();
        this.name = String.join(" ", list);
    }

    public Date toDate (String s) throws ParseException {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(2) != '/') sb.insert(0, '0');
        if (sb.charAt(5) != '/') sb.insert(3, '0');
        return new SimpleDateFormat("dd/MM/yyyy").parse(sb.toString());
    }

    public long getDays () {
        return TimeUnit.MILLISECONDS.toDays(departureDate.getTime() - arrivalDate.getTime()) + 1;
    }

    public int getPrice() {
        switch (room.charAt(0)) {
            case '1':   return 25;
            case '2':   return 34;
            case '3':   return 50;
            case '4':    return 80;
        }
        return 0;
    }

    public long getPayment() {
        return getDays() * getPrice() + service;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + room + " " + getDays() + " " + getPayment();
    }

}