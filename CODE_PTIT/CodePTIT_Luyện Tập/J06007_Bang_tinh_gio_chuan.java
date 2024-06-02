import java.util.*;

public class J06007_Bang_tinh_gio_chuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < n; i++)
            subjects.add(new Subject(sc.nextLine()));
        
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < m; i++)
            teachers.add(new Teacher(sc.nextLine()));
        
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            String[] s = sc.nextLine().split("\\s+");
            String teacherId = s[0];
            double time = Double.parseDouble(s[2]);
            for (Teacher t : teachers) 
                if (t.getId().equals(teacherId)) {
                    t.setTime(time + t.getTime());
                    break;
                }
        }

        teachers.forEach(System.out::println);

        sc.close();
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

