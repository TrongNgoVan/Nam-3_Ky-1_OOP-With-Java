import java.util.Scanner;

public class J04001 {
    static Scanner input = new Scanner(System.in);
    
    static public double distance (Point a, Point b) {
        double x = (a.getX() - b.getX());
        double y = (a.getY() - b.getY());
        return Math.sqrt( x*x + y*y);
    }

    static void test_case () {
        Point a = new Point (input.nextDouble(), input.nextDouble());
        Point b = new Point(input.nextDouble(), input.nextDouble());
        System.out.format("%.4f\n", distance(a, b));
    }
    public static void main(String[] args) {
        int t = input.nextInt();
        while (t-- > 0)
            test_case();
    }
}
class Point {
    private double x, y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point x(double x) {
        setX(x);
        return this;
    }

    public Point y(double y) {
        setY(y);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            "}";
    }
    
}