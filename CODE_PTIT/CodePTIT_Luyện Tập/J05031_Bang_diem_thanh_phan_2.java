import java.util.*;

public class J05031_Bang_diem_thanh_phan_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<SV> l = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            l.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()),
                    Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine())));
        }
        l.sort((a, b) -> a.name.compareTo(b.name));
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " " + l.get(i));
        }
        sc.close();
    }
}

class SV {
    String id, name, gr;
    float d1, d2, d3;

    public SV(String id, String name, String gr, float d1, float d2, float d3) {
        this.id = id;
        this.name = name;
        this.gr = gr;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gr + " " + d1 + " " + d2 + " " + d3;
    }
}
