import java.util.*;

public class J05029_Danh_sach_doanh_nghiep_nhan_sinh_vien_thuc_tap_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<DN> list = new ArrayList<>();
        while (t-- > 0) {
            list.add(new DN(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }
        list.sort((a, b) -> a.slot != b.slot ? b.slot - a.slot : a.id.compareTo(b.id));
        int q = Integer.parseInt(sc.nextLine());
        while (q-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.format("DANH SACH DOANH NGHIEP NHAN TU %d DEN %d SINH VIEN:\n", a, b);
            for (DN i : list)
                if (i.slot >= a && i.slot <= b)
                    System.out.println(i);
                else if (i.slot < a)
                    break;
        }
        sc.close();
    }
}

class DN {
    String id, name;
    int slot;

    public DN(String id, String name, int slot) {
        this.id = id;
        this.name = name;
        this.slot = slot;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + slot;
    }
}
