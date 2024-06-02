import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.*;

public class J05019_Luong_mua_trung_binh {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Data> list = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; i++) {
            boolean isExisted = false;
            Data data = new Data(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
            for (Data d : list) {
                if (d.getName().equals(data.getName())) {
                    d.setTime(data.getTime() + d.getTime());
                    d.setAmount(data.getAmount() + d.getAmount());
                    isExisted = true;
                    break;
                }
            }
            if (!isExisted) list.add(data);
        }
        list.forEach(System.out::println);
        sc.close();
    }
}

class Data {
    private String id, name;
    private Long amount;
    private double time;

    final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

    public Data(int id, String name, String start, String end, Long amount) throws ParseException {
        this.id = String.format("T%02d", id);
        this.name = name;
        this.time = timeDifference(start, end);
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    
    private double timeDifference (String start, String end) throws ParseException {
        long diff = dateFormat.parse(end).getTime() - dateFormat.parse(start).getTime();
        return TimeUnit.MILLISECONDS.toSeconds(diff) / 60.0;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.2f", amount * 60.0 / time);
    }

}