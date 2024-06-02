import java.util.*;

public class J05014_Tuyen_giao_vien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Teacher> list = new ArrayList<>();
        for (int i = 0; i < t; i++)
            list.add(new Teacher(i+1, sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        list.sort((a, b) -> a.getTotalPoint() == b.getTotalPoint() ? a.getId().compareTo(b.getId()) 
                                : a.getTotalPoint() < b.getTotalPoint() ? 1 : -1); 
        list.forEach(System.out::println); 
        sc.close();
    }
}

class Teacher {
    private int id;
    private String name;
    private String idd;
    private double point1, point2;

    public Teacher(int id, String name, String idd, double point1, double point2) {
        this.id = id;
        this.name = name;
        this.idd = idd;
        this.point1 = point1;
        this.point2 = point2;
    }

    public String getId() {
        return String.format("GV%02d", id);
    }

    public String getSubject() {
        String s = idd.substring(0, 1);
        switch (s) {
            case "A":
                return "TOAN";
            case "B":
                return "LY";
            case "C":
                return "HOA";
            default:
                return "";
        }
    }

    public double getBonus() {
        int n = Integer.parseInt(idd.substring(1, 2));
        switch (n) {
            case 1:
                return 2.0;
            case 2:
                return 1.5;
            case 3:
                return 1.0;
            default:
                return 0.0;
        }
    }

    public double getTotalPoint() {
        return point1 * 2 + point2 + getBonus();
    }

    public String getStatus() {
        if (getTotalPoint() >= 18) {
            return "TRUNG TUYEN";
        }
        return "LOAI";
    }

    @Override
    public String toString() {
        return getId() + " " + name + " " + getSubject() + " " + String.format("%.1f", getTotalPoint()) + " "
                + getStatus();
    }
}