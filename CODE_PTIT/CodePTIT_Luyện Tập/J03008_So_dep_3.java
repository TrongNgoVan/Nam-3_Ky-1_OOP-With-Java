import java.util.Arrays;
import java.util.Scanner;

public class J03008_So_dep_3 {
    static boolean[] primeDigit = new boolean[15];
    static void init() {
        Arrays.fill(primeDigit, false);
        primeDigit[2] = primeDigit[3] = primeDigit[5] = primeDigit[7] = true;
    }
    static boolean isValid (StringBuilder s) {
        for (int i = 0; i < s.length(); i++) {
            if (!primeDigit[s.charAt(i) - '0'])
                return false;
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            StringBuilder s = new StringBuilder(sc.next());
            System.out.println(isValid(s) ? "YES" : "NO");
            // System.out.println(s == s.reverse() && s.toString().matches("[^014689]+") ? "YES" : "NO");
        }
        sc.close();
    }
}
