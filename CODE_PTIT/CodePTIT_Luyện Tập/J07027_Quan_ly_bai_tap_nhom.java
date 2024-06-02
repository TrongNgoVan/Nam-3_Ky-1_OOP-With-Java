import java.util.*;
import java.io.*;

public class J07027_Quan_ly_bai_tap_nhom {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("SINHVIEN.in"));
        Scanner sc2 = new Scanner(new File("BAITAP.in"));
        Scanner sc3 = new Scanner(new File("NHOM.in"));
        ArrayList<SinhVien> SV = new ArrayList<>();

        int n = sc1.nextInt();
        sc1.nextLine();

        for (int i = 0; i < n; i++) {
            String id = sc1.nextLine();
            String name = sc1.nextLine();
            String phoneNum = sc1.nextLine();

            String[] strs = sc3.nextLine().split("\\s");
            int nhom = Integer.parseInt(strs[strs.length - 1]);

            SV.add(new SinhVien(id, name, phoneNum, nhom));
        }

        n = Integer.parseInt(sc2.nextLine());
        String mon = "";
        for (int j = 1; j <= n; j++) {
            mon = sc2.nextLine();
            for (int i = 0; i < SV.size(); i++) {
                if (SV.get(i).getNhom() == j) {
                    SV.get(i).setBaiTap(mon);
                }
            }
        }
        SV.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        SV.forEach(System.out::println);
    }
}

class SinhVien {
    private String id, name, phoneNum, baiTap;
    private int nhom;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getBaiTap() {
        return this.baiTap;
    }

    public int getNhom() {
        return this.nhom;
    }
    public void setBaiTap(String baiTap) {
        this.baiTap = baiTap;
    }

    SinhVien(String id, String name, String phoneNum, int nhom) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.nhom = nhom;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + phoneNum + " " + nhom + " " + baiTap;
    }
}