import java.util.*;

public class J05058_Sap_xep_ket_qua_tuyen_sinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            students.add(new Student(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        students.sort((a, b) -> a.totalScore.compareTo(b.totalScore) == 0 ? a.id.compareTo(b.id) : b.totalScore.compareTo(a.totalScore));
        students.forEach(System.out::println);
        sc.close();
    }
}

class Student {
    String id, name, status;
    Double score1, score2, score3, totalScore;

    public Student(String id, String name, double score1, double score2, double score3) {
        this.id = id;
        this.name = formatName(name);
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.totalScore = score1 * 2 + score2 + score3 + Double.parseDouble(getPriorityScore());
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
        if (totalScore >= 24)
            status = "TRUNG TUYEN";
        else
            status = "TRUOT";
        return String.format("%." + (totalScore.doubleValue() == totalScore.intValue() ? "0f" : "1f"), totalScore);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getPriorityScore() + " " + getScore() + " " + status;
    }
}
