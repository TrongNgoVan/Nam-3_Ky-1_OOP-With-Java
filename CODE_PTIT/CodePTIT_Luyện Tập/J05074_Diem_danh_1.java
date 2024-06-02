import java.util.*;

public class J05074_Diem_danh_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SV> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        for (int i = 0; i < n; i++) {
            String id = sc.next(), cc = sc.next();
            for (int j = 0; j < n; j++)
                if (list.get(j).id.equals(id)) {
                    list.get(j).setScore(cc);
                    break;
                }
        }
        list.forEach(System.out::println);
        sc.close();
    }
}

class SV {
    String id, name, gr, note;
    int score;
    
    public SV(String id, String name, String gr) {
        this.id = id;
        this.name = name;
        this.gr = gr;
        this.score = -1;
        this.note = "";
    }

    public void setScore(String cc) {
        int m = 0, v = 0;
        for (char i : cc.toCharArray())
            if (i == 'm')
                m++;
            else if (i == 'v')
                v++;
        this.score = Math.max(0, 10 - m - 2 * v);
        if (this.score == 0)
            this.note = "KDDK";
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gr + " " + score + " " + note;
    }
}
