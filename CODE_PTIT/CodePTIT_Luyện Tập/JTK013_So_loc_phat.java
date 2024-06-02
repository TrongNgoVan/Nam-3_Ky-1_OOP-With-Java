import java.util.*;

public class JTK013_So_loc_phat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            Queue<String> q = new LinkedList<>();
            Stack<String> st = new Stack<>();
            q.add("");
            String tmp = q.poll();
            while (tmp.length() < n) {
                st.push(tmp + "6");
                st.push(tmp + "8");
                q.add(tmp + "6");
                q.add(tmp + "8");
                tmp = q.poll();
            }
            System.out.println(st.size());
            while (!st.empty()) {
                System.out.print(st.peek() + " ");
                st.pop();
            }
            System.out.println();
        }
        sc.close();
    }
}
