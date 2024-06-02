import java.util.Scanner;

public class J01022 {
    static long fibo[] = new long[100];
    static void fibonacci () {
        fibo[0] = fibo[1] = 1;
        for (int i = 2; i < 93; i++)
            fibo[i] = fibo[i-1] + fibo[i-2];
    }
    static char divide (long k, int n) {
        if (n == 0) return '0';
        if (n == 1)    return '1';
        if (k < fibo[n-2]) return divide(k, n-2);
        return divide(k - fibo[n-2], n-1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        fibonacci();
        while (t-- > 0) {
            int n = input.nextInt();
            long k = input.nextLong();
            System.out.println(divide(k-1, n-1));
        }
        input.close();
    }
}
