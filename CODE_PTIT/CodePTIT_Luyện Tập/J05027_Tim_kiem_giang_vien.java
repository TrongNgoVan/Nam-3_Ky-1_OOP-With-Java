import java.util.*;

public class J05027_Tim_kiem_giang_vien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GV> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new GV(String.format("GV%02d", list.size() + 1), sc.nextLine(), sc.nextLine()));
        int q = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < q; t++) {
            String key = sc.nextLine();
            System.out.println(String.format("DANH SACH GIANG VIEN THEO TU KHOA %s:", key));
            for (GV i : list) {
                if (i.name.toLowerCase().contains(key.toLowerCase()))
                    System.out.println(i);
            }
        }
        sc.close();
    }
}

class GV {
    String code, name, sj;

    public GV(String sj) {
        setSubject(sj.split("\\s+"));
    }

    public GV(String code, String name, String sj) {
        this.name = name;
        this.code = code;
        setSubject(sj.split("\\s+"));
    }

    public void setSubject(String[] list) {
        String sj = "";
        for (String i : list)
            sj += Character.toUpperCase(i.charAt(0));
        this.sj = sj;
    }

    @Override
    public String toString() {
        return this.code + " " + this.name + " " + this.sj;
    }
}
