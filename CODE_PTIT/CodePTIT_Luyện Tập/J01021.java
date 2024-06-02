import java.util.Scanner;

public class J01021 {
    static final long mod = (long)(1e9+7);
    static long divide (long a, long b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        long tmp = divide(a, b/2) % mod;
        if (b%2 == 0)   return (tmp * tmp) % mod;
        else    return ((tmp * tmp) % mod * a) % mod;
}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a, b;
        while (true) {
            a = input.nextLong();
            b = input.nextLong();
            if (a == 0 && b == 0)   return;
            System.out.println(divide(a, b));
        }
    }
}
