import java.math.BigInteger;
import java.util.Scanner;

public class J03039_Chia_het {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            BigInteger a = input.nextBigInteger();
            BigInteger b = input.nextBigInteger();
            System.out.println((a.compareTo(b) > 0 ? a.mod(b) : b.mod(a)) == BigInteger.valueOf(0) ? "YES" : "NO");
        }
        input.close();
    }
}
