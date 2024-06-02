import java.util.*;

public class J02035_Quay_phai {
    static int shiftRightNumber (int n, int[] a) {
        int b[] = Arrays.copyOf(a, n), count = 0;
        Arrays.sort(b);
        while (!Arrays.equals(a, b)) {
            count++;
            int last = b[n-1];
            System.arraycopy(b, 0, b, 1, n-1);
            b[0] = last;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            System.out.println(shiftRightNumber(n, a));
        }
        sc.close();
    }
}
