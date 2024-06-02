import java.util.Scanner;

public class J01004 {
    static Scanner input = new Scanner(System.in);
    public static boolean isPrime (long n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
    static void test_case () {
        long n = input.nextLong();
        System.out.println(isPrime(n) ? "YES" : "NO");
    }
    public static void main(String[] args) {
        int t = input.nextInt();
        while (t-- > 0)
            test_case();
    }
}
