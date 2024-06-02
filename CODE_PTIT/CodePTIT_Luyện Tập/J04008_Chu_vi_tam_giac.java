import java.util.Scanner;

public class J04008_Chu_vi_tam_giac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            Triangle tr = new Triangle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            System.out.println(tr);
        }
        sc.close();
    }
}
class Triangle {
    double x1, y1, x2, y2, x3, y3;
    double a1, a2, a3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        a1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        a2 = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        a3 = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
    }
    @Override
    public String toString() {
        return (a1 + a2 > a3 && a2 + a3 > a1 && a3 + a1 > a2) ? String.format("%.3f", a1 + a2 + a3) : "INVALID";
    }
}