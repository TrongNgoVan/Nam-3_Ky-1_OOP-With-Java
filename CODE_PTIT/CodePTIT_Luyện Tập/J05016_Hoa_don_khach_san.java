
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class J05016_Hoa_don_khach_san {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Bill> bills = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            bills.add(new Bill(i, sc.nextLine(), sc.nextLine(), sc.nextLine(),
                    sc.nextLine(), Integer.parseInt(sc.nextLine())));
        bills.sort((a, b) -> {
            return b.getPrice() - a.getPrice();
        });
        bills.forEach(System.out::println);
        sc.close();
    }
}

class Bill {
    private String id;
    private String name;
    private String room;
    private Date dateIn;
    private Date dateOut;
    private long day;
    private int fee;
    private long price;

    public Bill(int id, String name, String room, String dateIn, String dateOut, int fee) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.id = String.format("KH%02d", id);
        this.name = name;
        this.room = room;
        this.dateIn = sdf.parse(dateIn);
        this.dateOut = sdf.parse(dateOut);
        this.fee = fee;
        this.day = prcDay();
        this.price = prcPrice();
    }

    public int getPrice() {
        return (int) price;
    }

    public long prcDay() {
        long getDiff = dateOut.getTime() - dateIn.getTime();
        long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
        return getDaysDiff + 1;
    }

    public long prcPrice() {
        int[] prices = { 0, 25, 34, 50, 80 };
        long price = day * prices[room.charAt(0) - '0'] + fee;
        return price;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + room + " " + day + " " + price;
    }
}