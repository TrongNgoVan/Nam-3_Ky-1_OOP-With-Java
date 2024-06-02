import java.util.Scanner;

public class J01009 {
    static Scanner input = new Scanner(System.in);
    static void test_case () {
        int n = input.nextInt();
        long res = 0, m = 1;
        for (int i = 1; i <= n; i++) {
            m *= i;
            res += m;
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        test_case();
    }
}
