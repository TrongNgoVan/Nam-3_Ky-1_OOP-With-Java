import java.util.*;

public class J05057_Bang_diem_tuyen_sinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            students.add(new Student(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        students.forEach(System.out::println);
        sc.close();
    }
}

class Student {
    String id, name, status;
    double score1, score2, score3;

    public Student(String id, String name, double score1, double score2, double score3) {
        this.id = id;
        this.name = formatName(name);
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    
    public String formatName(String name) {
        String[] list = name.trim().split("\\s+");
        for (int i = 0; i < list.length; i++)
            list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1).toLowerCase();
        return String.join(" ", list);
    }
    
    private String getPriorityScore() {
        switch (id.substring(2, 3)) {
            case "1":
                return "0.5";
            case "2":
                return "1";
            default:
                return "2.5";
        }
    }

    public String getScore() {
        double score = score1 * 2 + score2 + score3;
        if (score + Double.parseDouble(getPriorityScore()) >= 24)
            status = "TRUNG TUYEN";
        else
            status = "TRUOT";
        if (score == (int) score)
            return Integer.toString((int) score);
        return String.format("%.1f", score);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getPriorityScore() + " " + getScore() + " " + status;
    }
}