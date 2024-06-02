import java.util.Scanner;

public class J02008_Boi_so_nho_nhat_cua_n_so_nguyen_duong_dau_tien {
    static long gcd (long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }
    static long lcm (long a, long b) {
        return a / gcd(a, b) * b;
    }
    static Scanner sc = new Scanner(System.in);
    static void test_case () {
        long n = sc.nextLong();
        long res = 1;
        for (int i = 2; i <= n; i++) 
            res = lcm(res, i);
        System.out.println(res);
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) 
            test_case();
    }
}
