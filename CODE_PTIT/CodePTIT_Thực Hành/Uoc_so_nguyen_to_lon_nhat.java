package Practice;

import java.util.Scanner;

public class Uoc_so_nguyen_to_lon_nhat {
    static void max_divisor (long n) {
        if (n <= 3) {
            System.out.println(n);
            return;
        }
        long i = 2;
        while (i <= Math.sqrt(n)) {
            while (n%i == 0) 
                n /= i;
            i++;
        }
        System.out.println(n > 1 ? Math.max(n, i) : i);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            max_divisor(sc.nextLong());
        }
        sc.close();
    }
}
