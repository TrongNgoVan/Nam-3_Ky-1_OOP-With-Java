import java.util.ArrayList;
import java.util.Scanner;

public class DSA04020 {
    public static void BinarySearch (int l, int r, int k, ArrayList<Integer> a) {
        if (l > r) {
            System.out.println("NO");
            return;
        }
        int mid = (l+r) / 2;
        if (a.get(mid) == k) {
            System.out.println(mid + 1);
            return;
        }
        else if (a.get(mid) > k)    BinarySearch(mid+1, r, k, a);
        else    BinarySearch(l, mid-1, k, a);
    }
    public static void test_case () {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            a.add(x);
        }
        BinarySearch(0, n-1, k, a);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            t--;
            test_case();
        }
    }
}
