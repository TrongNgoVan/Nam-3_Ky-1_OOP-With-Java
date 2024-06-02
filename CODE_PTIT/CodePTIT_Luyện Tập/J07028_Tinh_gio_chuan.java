import java.util.*;
import java.io.*;

public class J07028_Tinh_gio_chuan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc1.nextLine());
        ArrayList<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < n; i++)
            subjects.add(new Subject(sc1.nextLine()));

        Scanner sc2 = new Scanner(new File("GIANGVIEN.in"));
        int m = Integer.parseInt(sc2.nextLine());
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < m; i++)
            teachers.add(new Teacher(sc2.nextLine()));

        Scanner sc3 = new Scanner(new File("GIOCHUAN.in"));
        int k = Integer.parseInt(sc3.nextLine());
        for (int i = 0; i < k; i++) {
            String[] s = sc3.nextLine().split("\\s+");
            String teacherId = s[0];
            double time = Double.parseDouble(s[2]);
            for (Teacher t : teachers)
                if (t.getId().equals(teacherId)) {
                    t.setTime(time + t.getTime());
                    break;
                }
        }

        teachers.forEach(System.out::println);
    }
}

class Subject {
    private String id, name;

    public Subject(String line) {
        String[] s = line.split("\\s+");
        this.id = s[0];
        this.name = String.join(" ", Arrays.copyOfRange(s, 1, s.length));
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

class Teacher {
    private String id, name;
    private double time = 0;

    public Teacher(String line) {
        String[] s = line.split("\\s+");
        this.id = s[0];
        this.name = String.join(" ", Arrays.copyOfRange(s, 1, s.length));
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name + " " + String.format("%.2f", time);
    }

}
