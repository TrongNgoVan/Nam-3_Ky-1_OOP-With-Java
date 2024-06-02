import java.text.DecimalFormat;
import java.util.*;

public class J05059_Xac_dinh_danh_sach_trung_tuyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();
        while (t-- > 0)
            students.add(new Student(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        
        students.sort((o1, o2) -> {
            if (o1.getSumMark() == o2.getSumMark()) {
                return o1.getId().compareTo(o2.getId());
            }
            return o1.getSumMark() < o2.getSumMark() ? 1 : -1;
        });

        int n = Integer.parseInt(sc.nextLine());
        double mark = students.get(n - 1).getSumMark();

        for (Student student : students) {
            if (student.getSumMark() >= mark) {
                student.setStatus("TRUNG TUYEN");
            } else {
                student.setStatus("TRUOT");
            }
        }

        System.out.println(String.format("%.1f", mark));
        students.forEach(System.out::println);
        sc.close();
    }
}

class Student {
    private String id;
    private String name;
    private double math;
    private double physic;
    private double chemistry;
    private String status;

    public Student(String id, String name, double math, double physic, double chemistry) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSumMark() {
        return math * 2 + physic + chemistry + getBonus();
    }

    public double getBonus() {
        String s = id.substring(0, 3);
        if (s.equals("KV1"))
            return 0.5;
        if (s.equals("KV2"))
            return 1.0;
        if (s.equals("KV3"))
            return 2.5;
        return 0;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String removeZero(double number) {
        DecimalFormat format = new DecimalFormat("#.###########");
        return format.format(number);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + removeZero(getBonus()) + " " + removeZero(getSumMark()) + " " + getStatus();
    }
}