import java.util.*;

public class J05021_Sap_xep_theo_ma_sinh_vien {
    public static void main(String[] args) {
        ArrayList<SV> sv = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                sv.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
            } catch (Exception e) {
                break;
            }
        }
        sv.sort((a, b) ->  a.code.compareTo(b.code));
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