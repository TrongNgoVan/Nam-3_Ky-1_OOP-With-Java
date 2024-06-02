import java.util.*;

public class J05066_Tim_kiem_nhan_vien_theo_ten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int gd = 1, tp = 3, pp = 3;
        ArrayList<NV> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String chucVu = s.substring(0, 2);
            String heSo = s.substring(2, 4);
            String id = s.substring(4, 7);
            String name = s.substring(8);
            if (chucVu.equals("GD")) {
                if (gd > 0 && Integer.parseInt(id) == 1) gd--;
                else chucVu = "NV";
            }
            if (chucVu.equals("TP")) {
                if (tp > 0 && Integer.parseInt(id) <= 3) tp--;
                else chucVu = "NV";
            }
            if (chucVu.equals("PP")) {
                if (pp > 0 && Integer.parseInt(id) <= 3) pp--;
                else chucVu = "NV";
            }
            list.add(new NV(chucVu, heSo, id, name));
        }

        list.sort((a, b) -> a.getHeSo().equals(b.getHeSo()) ? a.getId().compareTo(b.getId()) : Integer.valueOf(b.getHeSo()).compareTo(Integer.valueOf(a.getHeSo())));

        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String key = sc.nextLine().toLowerCase();
            list.forEach(e-> {
                if (e.getTen().toLowerCase().matches("^.*"+key+".*$"))
                    System.out.println(e);
            });
            System.out.println();
        }
        sc.close();
    }
}

class NV {
    private String chucVu, heSo, id, ten;

    public NV(String chucVu, String heSo, String id, String ten) {
        this.chucVu = chucVu;
        this.heSo = heSo;
        this.id = id;
        this.ten = ten;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getChucVu() {
        return this.chucVu;
    }

    public String getHeSo() {
        return this.heSo;
    }

    public String getId() {
        return this.id;
    }

    public String getTen() {
        return this.ten;
    }

    @Override
    public String toString() {
        return ten + " " + chucVu + " " + id + " " + heSo;
    }

}