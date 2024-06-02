import java.util.*;

public class J06003_Quan_ly_bai_tap_nhom_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        sc.nextLine();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            students.add(new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        ArrayList<String> exercise = new ArrayList<>();
        for (int i = 1; i <= m; i++)
            exercise.add(sc.nextLine());
        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            int index = Integer.parseInt(sc.nextLine());
            System.out.println(String.format("DANH SACH NHOM %d:", index));
            students.forEach(e -> {
                if (e.group == index)
                    System.out.println(e); 
            });
            System.out.println(String.format("Bai tap dang ky: %s", exercise.get(index - 1)));
        }
        sc.close();
    }
}

class Student {
    String id, name, phone;
    int group;

    public Student(String id, String name, String phone, int group) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.group = group;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + phone;
    }

}