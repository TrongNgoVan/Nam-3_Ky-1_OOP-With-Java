import java.util.*;

public class Hau_to {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String[] s = sc.nextLine().trim().split("\\s+");
            Stack<Long> st = new Stack<>();
            for (String i : s) {
                if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {
                    long fi = st.peek(); st.pop();
                    long se = st.peek(); st.pop();

                    if (i.equals("+")) st.push(se + fi);
                    if (i.equals("-")) st.push(se - fi);
                    if (i.equals("*")) st.push(se * fi);
                    if (i.equals("/")) st.push(se / fi);
                }
                else    st.push(Long.parseLong(i));
            }
            System.out.println(st.peek());
        }
        sc.close();
    }
}

// 3
// 7
// 2 3 1 * + 9 –
// 7
// 8 7 5 * + 9 –
// 3
// -10 -4 +