import java.util.*;

public class J05013_Tuyen_dung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            sc.nextLine();
            list.add(new Person(i + 1, sc.nextLine(), sc.nextDouble(), sc.nextDouble()));
        }

        list.sort((a, b) -> b.getTotalPoint().compareTo(a.getTotalPoint()));
        list.forEach(System.out::println);
        
        sc.close();
    }
}

class Person {
    private int id;
    private String name;
    private double pointA;
    private double pointB;

    public Person(int id, String name, double pointA, double pointB) {
        this.id = id;
        this.name = name;
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public String getId() {
        return String.format("TS%02d", id);
    }


    public double getPointA() {
        if (pointA > 10)
            return pointA /= 10;
        return pointA;
    }

    public double getPointB() {
        if (pointB > 10)
            return pointB /= 10;
        return pointB;
    }

    public Double getTotalPoint() {
        return (getPointA() + getPointB()) / 2;
    }

    public String getStatus() {
        if (getTotalPoint() < 5)
            return "TRUOT";
        if (getTotalPoint() < 8)
            return "CAN NHAC";
        if (getTotalPoint() <= 9.5)
            return "DAT";
        return "XUAT SAC";
    }

    @Override
    public String toString() {
        return getId() + " " + name + " " + String.format("%.2f", getTotalPoint()) + " " + getStatus();
    }
}