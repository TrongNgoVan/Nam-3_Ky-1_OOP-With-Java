import java.util.*;
import java.io.*;

public class J07018_Chuan_hoa_danh_sach_sinh_vien {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++)
            System.out.println(new Student(String.format("B20DCCN%03d", i), sc.nextLine(), sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine())));
    }
}

class Student {
    private String id;
    private String name;
    private String group;
    private String birthDay;
    private double GPA;


    public Student(String id, String name, String group, String birthDay, double GPA) {
        this.id = id;
        setName(name);
        this.group = group;
        setBirthDay(birthDay);
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String[] list = name.trim().split("\\s+");
        for (int i = 0; i < list.length; i++)
            list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1).toLowerCase();
        this.name = String.join(" ", list);
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        StringBuilder sb = new StringBuilder(birthDay);
        if (sb.charAt(1) == '/')
            sb.insert(0, '0');
        if (sb.charAt(4) == '/')
            sb.insert(3, '0');
        this.birthDay = sb.toString();
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return id + " " + getName() + " " + group + " " + getBirthDay() + " " + String.format("%.2f", GPA);
    }
}