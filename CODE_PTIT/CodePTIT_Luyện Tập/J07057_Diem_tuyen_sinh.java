import java.util.*;
import java.io.*;

public class J07057_Diem_tuyen_sinh {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            students.add(new Student(String.format("TS%02d", i), sc.nextLine(), Double.parseDouble(sc.nextLine()),
                    sc.nextLine(), sc.nextLine()));
        students.sort((a, b) -> (a.getTotalScore().compareTo(b.getTotalScore()) != 0) ? b.getTotalScore().compareTo(a.getTotalScore()) : a.id.compareTo(b.id));
        students.forEach(System.out::println);
    }
}

class Student {
    String id, name, area, status, ethnic;
    double score;
    
    public Student(String id, String name, double score, String ethnic, String area) {
        this.id = id;
        this.name = formatName(name);
        this.score = score;
        this.ethnic = ethnic;
        this.area = area;
        this.status = getTotalScore() >= 20.5 ? "Do" : "Truot";
    }
    
    public Double getTotalScore() {
        double sc = this.score;
        if (ethnic.equals("Kinh") == false)
            sc += 1.5;
        if (area.equals("1"))
            sc += 1.5;
        else if (area.equals("2"))
            sc += 1;
        return sc;
    }

    public String formatName(String name) {
        String[] list = name.trim().split("\\s+");
        for (int i = 0; i < list.length; i++)
            list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1).toLowerCase();
        return String.join(" ", list);
    }
    
    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.1f", getTotalScore()) + " " + status;
    }
}