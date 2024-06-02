import java.io.*;
import java.util.*;

public class J07073_Dang_ky_hinh_thuc_giang_day {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        ArrayList<Subject> list = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            Subject e = new Subject(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine());
            if (e.getFormatPractice().equals("Truc tuyen") || e.getFormatPractice().matches(".*\\.ptit\\.edu\\.vn$"))
                list.add(e);
        }
        // list.stream().filter(e -> e.getFormatPractice().equals("Truc tuyen") || e.getFormatPractice().matches(".*\\.ptit\\.edu\\.vn$")).toList().forEach(System.out::println);
        list.sort((a, b) -> a.getId().compareTo(b.getId()));
        list.forEach(System.out::println);
    }
}

class Subject {
    private String id, name;
    private Integer credits;
    private String formatTheory, formatPractice;

    public Subject(String id, String name, Integer credits, String formatTheory, String formatPractice) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.formatTheory = formatTheory;
        this.formatPractice = formatPractice;
    }

    public String getId() {
        return this.id;
    }

    public String getFormatPractice() {
        return this.formatPractice;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + credits + " " + formatTheory + " " + formatPractice;
    }

}