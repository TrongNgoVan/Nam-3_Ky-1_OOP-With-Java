import java.util.*;

public class J05024_Liet_ke_sinh_vien_theo_nganh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SV> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++)
            list.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        int q = Integer.parseInt(sc.nextLine());
        HashMap <String, String> hm = new HashMap<>();
        hm.put("Ke toan", "DCKT");
        hm.put("Cong nghe thong tin", "DCCN");
        hm.put("An toan thong tin", "DCAT");
        hm.put("Vien thong", "DCVT");
        hm.put("Dien tu", "DCDT");
        for (int i = 0; i < q; i++) {
            String key = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN NGANH " + key.toUpperCase() + ":");
            for (SV sv : list)
                if(key.equals("Cong nghe thong tin") || key.equals("An toan thong tin")) {
                    if (sv.gr.charAt(0) != 'E' && sv.code.contains(hm.get(key)))
                        System.out.println(sv);
                }
                else if (sv.code.contains(hm.get(key)))
                    System.out.println(sv);
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
