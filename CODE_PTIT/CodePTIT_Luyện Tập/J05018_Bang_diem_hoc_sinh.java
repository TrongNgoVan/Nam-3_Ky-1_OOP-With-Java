import java.util.*;

public class J05018_Bang_diem_hoc_sinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(new Student(i, sc.nextLine(), sc.nextLine().trim().split("\\s+")));
        list.sort((a, b) -> a.average != b.average ? (a.average < b.average ? 1 : -1) : a.id.compareTo(b.id));
        list.forEach(System.out::println);
        sc.close();
    }
}

class Student {
    String id, name;
    double average;

    public Student(int id, String name, String[] score) {
        this.id = String.format("HS%02d", id);
        this.name = name;
        this.average = getAverage(score);
    }

    public double getAverage(String[] score) {
        double res = Double.parseDouble(score[0]) * 2 + Double.parseDouble(score[1]) * 2;
        for (int i = 2; i < score.length; i++)  res += Double.parseDouble(score[i]);
        return res / 12;
    }

    String getRank () {
        if (average >= 9)   return "XUAT SAC";
        if (average >= 8)   return "GIOI";
        if (average >= 7)   return "KHA";
        if (average >= 5)   return "TB";
        return "YEU";
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.1f", Math.round(average*10.0) / 10.0) + " " + getRank();
    }

}
