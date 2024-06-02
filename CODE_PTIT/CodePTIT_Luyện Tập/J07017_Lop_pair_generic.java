import java.util.*;
import java.io.*;

public class J07017_Lop_pair_generic {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean check = false;
            for (int i = 2; i <= 2 * Math.sqrt(n); i++) {
                Pair<Integer, Integer> p = new Pair<>(i, n - i);
                if (p.isPrime()) {
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if (!check)
                System.out.println(-1);
        }
    }
}

class Pair<F, S> {

    F a;
    S b;

    public Pair(F a, S b) {
        this.a = a;
        this.b = b;
    }
    public boolean prime (int n) {
        if (n<2)    return false;
        if (n%2 == 0 && n>2)    return false;
        for (int i=3; i<=Math.sqrt(n); i+=2) {
            if (n%i == 0)   return false;
        }
        return true;
    }
    public boolean isPrime() {
        return prime(Integer.parseInt(a.toString())) && prime(Integer.parseInt(b.toString()));
    }

    @Override
    public String toString() {
        return a + " " + b;
    }
}
