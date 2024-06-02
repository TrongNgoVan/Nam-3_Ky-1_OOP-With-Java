import java.util.*;

public class J05020_Sap_xep_sinh_vien_theo_lop {
    public static void main(String[] args) {
        ArrayList<SV> sv = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++)
            sv.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        sv.sort((a, b) -> a.gr.equals(b.gr) ? a.code.compareTo(b.code) : a.gr.compareTo(b.gr));
        sv.forEach(System.out::println);
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