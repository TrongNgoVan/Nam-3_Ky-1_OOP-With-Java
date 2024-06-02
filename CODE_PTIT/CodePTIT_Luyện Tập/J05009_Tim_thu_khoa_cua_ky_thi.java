import java.util.*;

public class J05009_Tim_thu_khoa_cua_ky_thi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Candidate> ca = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            ca.add(new Candidate(i, sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()),
                    Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine())));
        ca.sort((a, b) -> {
            if (a.total == b.total)
                return a.id.compareTo(b.id);
            return b.total.compareTo(a.total);
        });
        float highest = ca.get(0).total;
        ca.forEach((e) -> {
            if (e.total == highest)
                System.out.println(e);
        });
        sc.close();
    }
}

class Candidate {
    String name, dob;
    Integer id;
    Float sj1, sj2, sj3, total;

    public Candidate(int id, String name, String dob, Float sj1, Float sj2, Float sj3) {
        this.name = name;
        this.dob = dob;
        this.id = id;
        this.sj1 = sj1;
        this.sj2 = sj2;
        this.sj3 = sj3;
        this.total = sj1 + sj2 + sj3;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + dob + " " + total;
    }

}