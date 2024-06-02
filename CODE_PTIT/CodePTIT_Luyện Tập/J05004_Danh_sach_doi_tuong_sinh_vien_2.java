import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class J05004_Danh_sach_doi_tuong_sinh_vien_2 {
    static public String nameFormat(String name) {
        String[] s = name.toLowerCase().trim().split("\\s+");
        for (int i = 0; i < s.length; i++)
            s[i] = s[i].substring(0, 1).toUpperCase() + s[i].substring(1);
        return String.join(" ", s);
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Student> st = new ArrayList<>();
        for (int i = 1; i <= t; i++)
            st.add(new Student(i, nameFormat(sc.nextLine()), sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine())));
        st.forEach(System.out::println);
        sc.close();
    }
}

class Student {
    String id, name, className, dob;
    Double gpa;

    public Student(int index, String name, String className, String dob, Double gpa) throws ParseException {
        this.id = "B20DCCN" + String.format("%03d", index);
        this.name = name;
        this.className = className;
        this.dob = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + className + " " + dob + " " + String.format("%.2f", gpa);
    }
}