
import java.util.*;
public class CTDL002 {
    public static void sumSubsequences (ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> a, ArrayList<Integer> tmp, int k, int sum, int i) {
        for (int j = i; j < a.size(); j++) {
            sum += a.get(j);
            tmp.add(a.get(j));
            if (sum == k)   ans.add(new ArrayList<>(tmp));
            else if (sum < k)   sumSubsequences(ans, a, tmp, k, sum, j+1);
            sum -= a.get(j);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void output (ArrayList<ArrayList<Integer>> ans) {
        for (int i = ans.size()-1; i>=0; i--) {
            for (int j:ans.get(i)) 
                System.out.print(j + " ");
            System.out.println();
        }
        System.out.println(ans.size());
    }
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer> > ans = new ArrayList<ArrayList<Integer>>();
        int n = input.nextInt(), k = input.nextInt(), x;
        for (int i = 0; i < n; i++) {
            x = input.nextInt();
            a.add(x);
        }
        Collections.sort(a);
        sumSubsequences(ans, a, new ArrayList<Integer>(), k, 0, 0);
        output(ans);
        input.close();
    }
}
