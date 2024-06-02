import java.math.BigInteger;
import java.util.Scanner;

public class J03011_Uoc_so_chung_lon_nhat_cua_so_nguyen_lon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            System.out.println(a.gcd(b));
        }
        sc.close();
    }
}
