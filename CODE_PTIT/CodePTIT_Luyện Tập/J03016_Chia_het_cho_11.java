import java.math.BigInteger;
import java.util.Scanner;

public class J03016_Chia_het_cho_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println(sc.nextBigInteger().mod(BigInteger.valueOf(11)) == BigInteger.valueOf(0) ? 1 : 0);
        }
        sc.close();
    }
}
