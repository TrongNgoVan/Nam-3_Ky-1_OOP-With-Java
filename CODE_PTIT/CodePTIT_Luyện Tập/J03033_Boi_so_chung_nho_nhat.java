import java.math.BigInteger;
import java.util.Scanner;

public class J03033_Boi_so_chung_nho_nhat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            BigInteger a = input.nextBigInteger();
            BigInteger b = input.nextBigInteger();
            System.out.println(a.divide(a.gcd(b)).multiply(b));
        }
        input.close();
    }
}
