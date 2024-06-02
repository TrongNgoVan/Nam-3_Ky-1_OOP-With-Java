import java.util.*;

public class J05035_Danh_sach_thuc_tap_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        ArrayList<Student> list = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            list.add(new Student(i + 1, sc.nextLine(), sc.nextLine(),
                    sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        list.sort((a, b) -> a.id.compareTo(b.id));
        int Q = sc.nextInt();
        sc.nextLine();
        while (Q-- > 0) {
            String company = sc.nextLine();
            for (int i = 0; i < t; i++) {
                if (company.equals(list.get(i).company)) {
                    System.out.println(list.get(i));
                }
            }
        }
        sc.close();
    }

}

class Student {
    String id, name, className, email, company;
    int ordinals;

    public Student(int ordinals, String id, String name, String className, String email, String company) {
        this.ordinals = ordinals;
        this.id = id;
        this.name = name;
        this.className = className;
        this.email = email;
        this.company = company;
    }

    @Override
    public String toString() {
        return ordinals + " " + id + " " + name + " " + className + " " + email + " " + company;
    }
}