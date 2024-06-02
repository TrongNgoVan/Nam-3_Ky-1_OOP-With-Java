import java.util.*;

public class J02025_Day_con_co_tong_nguyen_to {
    static int[] a = new int[0];
    static int n;
    static ArrayList<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            set = new ArrayList<>();
            n = sc.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a);
            Try(n - 1, 0, "");
        }
        sc.close();
    }

    public static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n < 5 || n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    public static void Try(int i, int sum, String list) {
        for (int k = 0; k < 2; k++) {
            if (k == 1) {
                sum += a[i];
                list += Integer.toString(a[i]) + " ";
            }
            if (i == 0) {
                if (isPrime(sum))
                    System.out.println(list);
            } else
                Try(i - 1, sum, list);
        }
    }
}
