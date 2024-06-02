import java.util.*;

public class J08021_Day_ngoac_dung_dai_nhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            char[] s = ("0" + sc.nextLine()).split("\\.")[0].toCharArray();
            Stack<Integer> st = new Stack<>();
            int res = 0;
            st.push(0);
            for (int i = 1; i < s.length; i++) {
                if (!st.empty() && s[st.peek()] == '(' && s[i] == ')') {
                    st.pop();
                    res = Math.max(res, i - st.peek());
                }
                else st.push(i);
            }
            System.out.println(res);
        }
        sc.close();
    }
}
