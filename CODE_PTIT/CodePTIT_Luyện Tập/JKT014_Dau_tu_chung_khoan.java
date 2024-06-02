import java.util.*;

public class JKT014_Dau_tu_chung_khoan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Stack<Integer> st = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();
            int[] arr = new int[n+5];
            for (int i = 0; i < n; i++) 
                arr[i] = sc.nextInt();
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && arr[i] >= arr[st.peek()]) 
                    st.pop();
                list.add(st.isEmpty() ? i+1 : i-st.peek());
                st.push(i);
            }
            list.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }

        sc.close();
    }
}
