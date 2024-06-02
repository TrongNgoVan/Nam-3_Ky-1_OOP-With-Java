import java.util.*;
import java.io.*;

public class J07052_Danh_sach_trung_tuyen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        ArrayList<TS> ts = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            ts.add(new TS(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        ts.sort((a, b) -> {
            if (a.total == b.total)
                return a.id.compareTo(b.id);
            return b.total.compareTo(a.total);
        });

        int amount = Integer.parseInt(sc.nextLine());
        double benchmark;
        if (amount >= n) {
            for (TS i : ts) i.status = "TRUNG TUYEN";
            benchmark = ts.get(n-1).total;
        }
        else {
            benchmark = ts.get(amount - 1).total;
            for (TS i : ts) {
                i.status = (i.total >= benchmark) ?  "TRUNG TUYEN" : "TRUOT";
            }
        }
        System.out.println(String.format("%.1f", benchmark));
        ts.forEach(System.out::println);
    }
}

class TS {
    String id, name, status;
    Double math, physics, chemistry, priority, total;

    public TS(String id, String name, Double math, Double physics, Double chemistry) {
        this.id = id;
        this.name = formatName(name);
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.total = math*2 + physics + chemistry + getPriority();
        this.priority = getPriority();
    }

    public double getPriority() {
        switch (id.charAt(2)) {
            case '1': return 0.5;
            case '2': return 1.0;
            case '3':   return 2.5;
        }
        return 0;
    }


    public String formatName(String name) {
        String[] list = name.trim().split("\\s+");
        for (int i = 0; i < list.length; i++)
            list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1).toLowerCase();
        return String.join(" ", list);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + (priority == priority.intValue() ? priority.intValue() : String.format("%.1f", priority)) 
            + " " + (total == total.intValue() ? total.intValue() : String.format("%.1f", total)) + " " + status;
    }
 
}