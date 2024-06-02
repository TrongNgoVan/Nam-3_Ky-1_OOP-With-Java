import java.util.*;

public class J05026_Danh_sach_giang_vien_theo_bo_mon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GV> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new GV(String.format("GV%02d", list.size() + 1), sc.nextLine(), sc.nextLine()));
        int q = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < q; t++) {
            String sj = new GV(sc.nextLine()).sj;
            System.out.println(String.format("DANH SACH GIANG VIEN BO MON %s:", sj));
            for (GV i : list) {
                if (i.sj.equals(sj))
                    System.out.println(i);
            }
        }
        // list.forEach(System.out::println);
        sc.close();
    }
}

class GV {
    String code, name, sj, lastName;

    public GV(String sj) {
        setSubject(sj.split("\\s+"));
    }

    public GV(String code, String name, String sj) {
        this.name = name;
        this.code = code;
        setSubject(sj.split("\\s+"));
        setLastName(name.split("\\s+"));
    }

    public void setSubject(String[] list) {
        String sj = "";
        for (String i : list)
            sj += Character.toUpperCase(i.charAt(0));
        this.sj = sj;
    }

    public void setLastName(String[] name) {
        this.lastName = name[name.length - 1];
    }

    @Override
    public String toString() {
        return this.code + " " + this.name + " " + this.sj;
    }
}
