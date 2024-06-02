import java.util.*;

public class J05080_Lop_hoc_phan_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Classroom> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            list.add(new Classroom(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        list.sort((a, b) -> a.getId().equals(b.getId()) ? a.getGroup().compareTo(b.getGroup()) : a.getId().compareTo(b.getId()));
        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            String teacher = sc.nextLine();
            System.out.println(String.format("Danh sach cho giang vien %s:", teacher));
            list.forEach(e -> {
                if (e.getTeacher().equals(teacher))
                    System.out.println(e);
            });
        }
        sc.close();
    }
}

class Classroom {
    private String id, name, group, teacher;

    public Classroom(String id, String name, String group, String teacher) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.teacher = teacher;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGroup() {
        return this.group;
    }

    public String getTeacher() {
        return this.teacher;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + group;
    }

}