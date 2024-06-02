import java.util.*;

public class J05022_Liet_ke_sinh_vien_theo_lop {
    public static void main(String[] args) {
        ArrayList<SV> sv = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++)
            sv.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        int q = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < q; t++) {
            String gr = sc.nextLine();
            System.out.format("DANH SACH SINH VIEN LOP %s:\n", gr);
            for (SV i : sv)
                if (i.gr.equals(gr))
                    System.out.println(i);
        }
        sc.close();
    }
}

class SV {
    String code, name, gr, mail;

    public SV(String code, String name, String gr, String mail) {
        this.code = code;
        this.name = name;
        this.gr = gr;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return code + " " + name + " " + gr + " " + mail;
    }
}