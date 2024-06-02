import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class J05011_Tinh_gio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Player> pl = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            pl.add(new Player(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        pl.sort((a, b) -> -a.time.compareTo(b.time));
        pl.forEach(System.out::println);
        sc.close();
    }
}

class Player {
    String id, name, start, end;
    Long time;

    public Player(String id, String name, String start, String end) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        Date d1 = null, d2 = null;
        try {
            d1 = new SimpleDateFormat("HH:mm").parse(start);
            d2 = new SimpleDateFormat("HH:mm").parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.time = d2.getTime() - d1.getTime();
    }

    public String timeCounting() {
        return String.format("%d gio %d phut", TimeUnit.MILLISECONDS.toHours(time),
                TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)));
    }

    @Override
    public String toString() {
        return id + " " + name + " " + timeCounting();
    }

}