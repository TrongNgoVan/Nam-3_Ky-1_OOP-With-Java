import java.util.*;

public class J06004_Quan_ly_bai_tap_nhom_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        sc.nextLine();
        ArrayList<Student> st = new ArrayList<>();
        ArrayList<String> exercise = new ArrayList<>();
        exercise.add(null);
        for (int i = 1; i <= n; i++)
            st.add(new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        for (int i = 1; i <= m; i++)
            exercise.add(sc.nextLine());
        Collections.sort(st);
        for (Student i : st)
            System.out.println(i + exercise.get(i.index));
    }
}

class Student implements Comparable<Student> {
    String id, name, phone;
    Integer index;

    public Student(String id, String name, String phone, Integer index) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.index = index;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + phone + " " + index + " ";
    }

    @Override
    public int compareTo(Student o) {
        return id.compareTo(o.id);
    }
}