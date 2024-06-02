import java.util.*;

public class J02026_Day_con_co_k_phan_tu_tang_dan {
    static int[] a;
    static int n, k;
    static ArrayList<Integer> c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            a = new int[n];
            c = new ArrayList<>();
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a);
            backtrack(0);
        }
        sc.close();
    }

    static void backtrack (int i) {
        for (int j = i; j < n; j++) {
            c.add(a[j]);
            if (c.size() == k)  output();
            if (c.size() < k)   backtrack(j+1);
            c.remove(c.size()-1);
        }
    }

    static void output () {
        c.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
