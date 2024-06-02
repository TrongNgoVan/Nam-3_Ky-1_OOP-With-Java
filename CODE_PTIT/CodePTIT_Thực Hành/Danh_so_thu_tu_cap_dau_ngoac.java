import java.util.*;

public class Danh_so_thu_tu_cap_dau_ngoac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            char[] s = sc.nextLine().split("\\.")[0].toCharArray();
            Stack<Integer> st = new Stack<>();
            ArrayList<Integer> res = new ArrayList<>();
            int count = 1;
            for (char i : s) {
                if (i == '(' || i == '[') {
                    res.add(count);
                    st.push(count++);
                }
                else if (!st.empty() && i == ')') {
                    res.add(st.peek());
                    st.pop();
                }
            }
            res.forEach(e -> {
                System.out.print(e + " ");
            });
            System.out.println();
        }
        sc.close();
    }
}

// 2
// (a + (b *c) ) + (d/e)
// ( ( () ) ( () ) )
