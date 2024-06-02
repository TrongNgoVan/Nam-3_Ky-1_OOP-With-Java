import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class J05071_Tinh_cuoc_dien_thoai_co_dinh_2 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<City> cities = new ArrayList<>();
        City NM = new City("", "Noi mang", Long.valueOf("800"));
        for (int i = 0; i < n; i++)
            cities.add(new City(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine())));
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Call> calls = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] s = sc.nextLine().split("\\s+");
            if (s[0].charAt(0) != '0')
                calls.add(new Call(s[0], s[1], s[2], NM));
            else {
                String id = s[0].substring(1, 3);
                for (City j : cities) {
                    if (j.getId().equals(id)) {
                        calls.add(new Call(s[0], s[1], s[2], j));
                        break;
                    }
                }
            }
        }
        calls.sort((a, b) -> b.getTotal().compareTo(a.getTotal()));
        calls.forEach(System.out::println);
        sc.close();
    }
}

class City {
    private String id, name;
    private Long price;

    public City(String id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

}

class Call {
    private String phone, start, end;
    private City city;
    private long time;

    public Call(String phone, String start, String end, City city) throws ParseException {
        this.phone = phone;
        this.start = start;
        this.end = end;
        this.city = city;
        this.time = getTime();
    }

    private long getTime() throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("HH:mm");
        long time = TimeUnit.MILLISECONDS.toMinutes(s.parse(end).getTime() - s.parse(start).getTime());
        if (city.getName().equals("Noi mang"))
            return (long) Math.ceil(time * 1.0 / 3);
        return time;
    }

    public Long getTotal() {
        return time * city.getPrice();
    }

    @Override
    public String toString() {
        return phone + " " + city.getName() + " " + time + " " + getTotal(); // Generated from
                                                                             // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}