import java.util.Scanner;
public class J01005 {
    static Scanner input = new Scanner(System.in);
    static void test_case () {
        int n = input.nextInt();
        double h = input.nextDouble();
        for (int i = 1; i < n; i++) 
            System.out.format("%.6f ", h*Math.sqrt((double)i/n));
        System.out.println();
    }
    public static void main(String[] args) {
        int t = input.nextInt();
        while (t-- > 0)
            test_case();
    }
}
