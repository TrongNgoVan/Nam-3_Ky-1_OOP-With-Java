import java.util.Scanner;

public class J01007 {
    static Scanner input = new Scanner(System.in);
    static long[] fibo = new long[95];
    static void Init () {
        for (int i = 0; i <= 92; i++)   fibo[i] = 0; 
        fibo[1] = fibo[2] = 1;
        for (int i = 3; i <= 92; i++) 
            fibo[i] = fibo[i-1] + fibo[i-2];
    }
    static boolean isFibonacci (long n) {
        for (int i = 0; i <= 92; i++)
            if (n == fibo[i])   return true;
            else if (n > fibo[i] && n < fibo [i+1]) return false;
        return false;
    }
    static void test_case () {
        long n = input.nextLong();
        System.out.println(isFibonacci(n) ? "YES" : "NO");
    }
    public static void main(String[] args) {
        Init(); 
        int t = input.nextInt();
        while (t-- > 0)
            test_case();
    }
}
