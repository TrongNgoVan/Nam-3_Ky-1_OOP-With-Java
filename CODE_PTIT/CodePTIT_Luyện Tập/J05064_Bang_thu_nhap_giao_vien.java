import java.util.*;

public class J05064_Bang_thu_nhap_giao_vien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Teacher> list = new ArrayList<>();
        int ht = 0, hp = 0;
        for (int i = 0; i < n; i++) {
            Teacher teacher = new Teacher(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
            if (ht >= 1 && teacher.id.substring(0, 2).equals("HT") || hp >= 2 && teacher.id.substring(0, 2).equals("HP"))
                continue;
            list.add(teacher);
            if (teacher.id.substring(0, 2).equals("HT"))
                ht++;
            else if (teacher.id.substring(0, 2).equals(("HP")))
                hp++;
        }
        list.forEach(System.out::println);
        sc.close();
    }
}

class Teacher {
    String id, name;
    int salary;

    public Teacher(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getCoefficient() {
        return Integer.parseInt(id.substring(2, 4));
    }

    public int getAllowance() {
        String position = id.substring(0, 2);
        switch (position) {
            case "HT":
                return 2000000;
            case "HP":
                return 900000;
            default:
                return 500000;
        }
    }

    public int getIncome() {
        return salary * getCoefficient() + getAllowance();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getCoefficient() + " " + getAllowance() + " " + getIncome();
    }
}