import java.util.*;

public class J05008_Dien_tich_da_giac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<Point> list = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++)
                list.add(new Point(sc.nextDouble(), sc.nextDouble()));

            double sum1 = 0, sum2 = 0;
            for (int i = 0; i < n; i++) {
                sum1 += list.get(i).getX() * list.get((i+1)%n).getY();
                sum2 += list.get(i).getY() * list.get((i+1)%n).getX();
            }
            System.out.println(String.format("%.3f", Math.abs(sum1 - sum2)/2));
        }
        sc.close();
    }
}

class Point {
    private double x, y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distance (Point b) {
        return Math.sqrt((x - b.getX()) * (x - b.getX()) + (y - b.getY()) * (y - b.getY()));
    }
}
