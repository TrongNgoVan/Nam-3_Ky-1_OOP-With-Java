import java.text.DecimalFormat;
import java.util.Scanner;

public class J04013_Bai_toan_tuyen_sinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Candidate ts = new Candidate(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println(ts);
        sc.close();
    }
}

class Candidate {
    String id, name, status;
    Double math, physic, chemistry, priority, total;

    public Candidate(String id, String name, Double math, Double physic, Double chemistry) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
        this.total = math*2 + physic + chemistry;
        if (id.substring(0, 3).equals("KV1"))   this.priority = 0.5;
        else if (id.substring(0, 3).equals("KV2"))   this.priority = 1.0;
        else if (id.substring(0, 3).equals("KV3"))   this.priority = 2.5;
        this.status = (this.total + this.priority >= 24) ? "TRUNG TUYEN" :"TRUOT";
    }

    @Override
    public String toString() {
        return id + " " + name + " " + new DecimalFormat("0.#").format(priority) 
            + " " +  new DecimalFormat("0.#").format(total) + " " + status;
    }

}