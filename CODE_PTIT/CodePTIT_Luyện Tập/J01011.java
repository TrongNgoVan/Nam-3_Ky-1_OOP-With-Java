import java.util.Scanner;

public class J01011 {
    static Scanner input = new Scanner(System.in);
    static long __gcd (long a, long b) {
        if (b == 0) return a;
        else return __gcd(b, a%b);
    }
    static void test_case () {
        long a = input.nextLong();
        long b = input.nextLong();
        long ucln = __gcd(a, b);
        System.out.println((a / ucln * b) + " " + ucln);
    }
    public static void main(String[] args) {
        int t = input.nextInt();
        while (t-- > 0)
            test_case();
    }
}
