import java.util.*;

public class J08023_Hinh_chu_nhat_lon_nhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
                
            int[] l = new int[n]; Arrays.fill(l, 0);
            int[] r = new int[n]; Arrays.fill(r, 0);
            Stack<Integer> st = new Stack<>();

            // vi tri phan tu ben phai dau tien nho hon
            // => danh dau phan tu ben phai lon hon bang
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && a[i] <= a[st.peek()])
                    st.pop();
                r[i] = st.empty() ? n - 1 : st.peek() - 1;
                st.push(i);
            }
            while (!st.isEmpty())   st.pop();

            // vi tri phan tu ben trai dau tien nho hon
            // => danh dau phan tu ben trai lon hon bang
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && a[i] <= a[st.peek()])
                    st.pop();
                l[i] = st.empty() ? 0 : st.peek() + 1;
                st.push(i);
            }

            // Ket qua
            long res = 0;
            for (int i = 0; i < n; i++)
                res = Math.max((long)a[i] * (r[i] - l[i] + 1), res);
            System.out.println(res);
        }
        sc.close();
    }
}
