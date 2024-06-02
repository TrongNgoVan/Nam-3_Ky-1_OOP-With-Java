package Practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Nho_nhat_va_lon_nhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        do {
            ArrayList<BigInteger> a = new ArrayList<>();
            for (int i = 0; i < n; i++) 
                a.add(sc.nextBigInteger());
            Collections.sort(a);
            BigInteger min = a.get(0), max = a.get(n-1);
            System.out.println(min.equals(max) ? "BANG NHAU" : min + " " + max);
            n = sc.nextInt();
        } while (n != 0);
        sc.close();
    }
}
