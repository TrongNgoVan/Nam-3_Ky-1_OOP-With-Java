import java.util.*;

public class J08022_Phan_tu_ben_phai_dau_tien_lon_hon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> st = new Stack<>();
            Stack<Integer> res = new Stack<>();
            int n = sc.nextInt();
            int[] a = new int[n+2];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = n-1; i >= 0; i--) {
                while (!st.empty() && a[i] >= st.peek()) 
                    st.pop();
                res.push(st.empty() ? -1 : st.peek());
                st.push(a[i]);
            }
            while (!res.empty()) {
                System.out.print(res.peek() + " ");
                res.pop();
            }
            System.out.println();
        }
        sc.close();
    }
}
