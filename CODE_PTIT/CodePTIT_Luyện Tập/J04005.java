import java.util.Scanner;

public class J04005 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ThiSinh ts = new ThiSinh(input.nextLine(), input.nextLine(), 
        input.nextDouble(), input.nextDouble(), input.nextDouble());
        System.out.format(ts + " %.1f", ts.TongDiem());
        input.close();
    }
}

class ThiSinh {
    String name, dob;
    private double m1, m2, m3;

    public ThiSinh(String name, String dob, double m1, double m2, double m3) {
        this.name = name;
        this.dob = dob;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public double TongDiem () {
        return m1 + m2 + m3;
    }

    @Override
    public String toString() {
        return name + " " + dob;
    }

}