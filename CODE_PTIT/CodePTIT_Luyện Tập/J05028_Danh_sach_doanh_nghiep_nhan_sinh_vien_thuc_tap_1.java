import java.util.*;

public class J05028_Danh_sach_doanh_nghiep_nhan_sinh_vien_thuc_tap_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<DN> list = new ArrayList<>();
        while (t-- > 0) {
            list.add(new DN(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }
        list.sort((a, b) -> a.slot != b.slot ? b.slot - a.slot : a.id.compareTo(b.id));
        list.forEach(System.out::println);
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