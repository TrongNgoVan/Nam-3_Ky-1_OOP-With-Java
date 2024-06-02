import java.util.*;

public class J05079_Lop_hoc_phan_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Classroom> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            map.put(id, name);
            list.add(new Classroom(id, name, sc.nextLine(), sc.nextLine()));
        }
        list.sort((a, b) -> a.getGroup().compareTo(b.getGroup()));
        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            String id = sc.nextLine();
            System.out.println(String.format("Danh sach nhom lop mon %s:", map.get(id)));
            list.forEach(e -> {
                if (e.getId().equals(id))
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

    public String getGroup() {
        return this.group;
    }

    @Override
    public String toString() {
        return group + " " + teacher;
    }

}