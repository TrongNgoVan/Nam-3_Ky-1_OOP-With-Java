import java.util.*;

public class So_cap_ban_tot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int res = 0;
        ArrayList<String> name = new ArrayList<>();
        int[] len = new int[505];
        Arrays.fill(len, 0);
        for (int i = 0; i < n; i++) 
            name.add(sc.next());
        for (int i = 0; i <= k; i++) {
            res += len[name.get(i).length()];
            ++len[name.get(i).length()];
        }
        for (int i = k+1; i < n; i++) {
            --len[name.get(i - k - 1).length()];
            res += len[name.get(i).length()];
            ++len[name.get(i).length()];
        }
        System.out.println(res);
        sc.close();
    }
}

// 4 2
// NAM
// TAM
// THU
// HAI

// 6 3
// NAM
// TRUNG
// TRUONG
// HUYEN
// TU
// NGUYEN