import java.util.*;

public class J08015_Cap_so_co_tong_bang_k {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            HashMap<Long, Long> map = new HashMap<>();
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] a = new long[n+5];
            long res = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                if (map.get(k - a[i]) != null)
                    res += map.get(k - a[i]);
                map.put(a[i], map.get(a[i]) != null ? map.get(a[i]) + 1 : 1);
            }
            System.out.println(res);
        }
        sc.close();
    }
}
