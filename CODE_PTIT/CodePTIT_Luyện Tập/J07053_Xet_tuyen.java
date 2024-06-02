import java.util.*;
import java.io.*;

public class J07053_Xet_tuyen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        ArrayList<XT> xt = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            xt.add(new XT(i, sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        xt.forEach(System.out::println);
    }
}

class XT {
    Double lt, th, bonus;
    String rank, name, id;
    Integer age;

    public XT(int i, String name, String dob, Double lt, Double th) {
        this.id = String.format("PH%02d", i);
        this.lt = lt;
        this.th = th;
        this.name = formatName(name);
        this.age = 2021 - Integer.parseInt(formatDate(dob).substring(6, 10));

        if (lt >= 8 && th >= 8) this.bonus = 1.0;
        else if (lt >= 7.5 && th >= 7.5)    this.bonus = 0.5;
        else this.bonus = 0.0;

        switch (getScore()) {
            case 10:
            case 9:
                this.rank = "Xuat sac";
                break;
            case 8:
                this.rank = "Gioi";
                break;
            case 7:
                this.rank = "Kha";
                break;
            case 6:
            case 5:
                this.rank = "Trung binh";
                break;
            default:
                this.rank = "Truot";
        }
    }

    public String formatDate(String s)  {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(2) != '/')
            sb.insert(0, '0');
        if (sb.charAt(5) != '/')
            sb.insert(3, '0');
        return sb.toString();
    }

    public String formatName(String name) {
        String[] list = name.trim().split("\\s+");
        for (int i = 0; i < list.length; i++)
            list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1).toLowerCase();
        return String.join(" ", list);
    }

    public int getScore() {
        return (int) Math.min(10, Math.round((lt + th) / 2 + bonus));
    }
    
    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + getScore() + " " + rank;
    }
}