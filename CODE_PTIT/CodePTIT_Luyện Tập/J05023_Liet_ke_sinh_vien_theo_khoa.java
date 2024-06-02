import java.util.*;

public class J05023_Liet_ke_sinh_vien_theo_khoa {
    public static void main(String[] args) {
        ArrayList<SV> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++)
            list.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String sYear = sc.nextLine().substring(2, 4);
            System.out.format("DANH SACH SINH VIEN KHOA 20%s:\n", sYear);
            for (SV sv : list)
                if (sv.sYear.equals(sYear))
                    System.out.println(sv);
        }
        sc.close();
    }
}

class SV {
    String code, name, gr, mail, sYear;

    public SV(String code, String name, String gr, String mail) {
        this.code = code;
        this.name = name;
        this.gr = gr;
        this.mail = mail;
        this.sYear = gr.substring(1, 3);
    }

    @Override
    public String toString() {
        return code + " " + name + " " + gr + " " + mail;
    }
}