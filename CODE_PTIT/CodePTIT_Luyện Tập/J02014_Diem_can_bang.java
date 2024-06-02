import java.util.Scanner;

public class J02014_Diem_can_bang {
    static Scanner sc = new Scanner(System.in);
    static void test_case () {
        int n = sc.nextInt();
        int[] a = new int[n+5];
        int left = 0, right = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            right += a[i];
        }
        for (int i = 1; i <= n; i++) {
            left += a[i-1];
            right -= a[i];
            if (left == right) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0)
            test_case();
    }
}
