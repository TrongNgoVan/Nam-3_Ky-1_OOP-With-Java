import java.util.*;

public class J06008_Tinh_gio_chuan_cho_tung_giang_vien {
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
            String teacherId = s[0], sjId = s[1];
            double time = Double.parseDouble(s[2]);
            for (Teacher t : teachers)
                if (t.getId().equals(teacherId)) {
                    for (Subject sj : subjects) 
                        if (sj.getId().equals(sjId)) {
                            t.addSjs(new Subject(sjId, sj.getName(), time));
                            break;
                        }
                    break;
                }
        }

        String teacherId = sc.nextLine();
        teachers.forEach(e -> {
            if (e.getId().equals(teacherId)) 
                System.out.println(e);
        });

        sc.close();
    }
}

class Subject {
    private String id, name;
    private double time = 0;

    public Subject(String id, String name, double time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }


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


    public double getTime() {
        return this.time;
    }


    @Override
    public String toString() {
        return name + " " + time;
    }
}

class Teacher {
    private String id, name;
    private double time = 0;
    private ArrayList<Subject> sjs;

    public Teacher(String line) {
        this.sjs = new ArrayList<>();
        String[] s = line.split("\\s+");
        this.id = s[0];
        this.name = String.join(" ", Arrays.copyOfRange(s, 1, s.length));
    }


    public void addSjs(Subject sj) {
        this.sjs.add(sj);
    }

    public double getTime() {
        for (Subject sj : sjs)
            this.time += sj.getTime();
        return this.time;
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String res = String.format("Giang vien: %s\n", name);
        for (Subject sj : sjs)
            res += sj + "\n";
        return res + String.format("Tong: %.2f", getTime());
    }

}
