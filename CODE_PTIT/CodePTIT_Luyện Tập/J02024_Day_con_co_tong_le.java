import java.util.*;

public class J02024_Day_con_co_tong_le {
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

    public static void Try(int i, int sum, String list) {
        for (int k = 0; k < 2; k++) {
            if (k == 1) {
                sum += a[i];
                list += Integer.toString(a[i]) + " ";
            }
            if (i == 0) {
                if (sum % 2 == 1)
                    System.out.println(list);
            } else
                Try(i - 1, sum, list);
        }
    }
}
