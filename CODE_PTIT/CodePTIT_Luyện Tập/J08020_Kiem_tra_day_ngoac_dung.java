import java.util.*;

public class J08020_Kiem_tra_day_ngoac_dung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            char[] s = sc.nextLine().split("\\.")[0].toCharArray();
            Stack<Character> st = new Stack<>();
            for (char i : s) {
                if (!st.empty() && i == ')' && st.peek() == '(')
                    st.pop();
                else if (!st.empty() && i == ']' && st.peek() == '[')
                    st.pop();
                else if (!st.empty() && i == '}' && st.peek() == '{')
                    st.pop();
                else if (i == '(' || i == ')' || i == '[' || i == ']' || i == '{' || i == '}')
                    st.push(i);
            }
            System.out.println(st.empty() ? "YES" : "NO");
        }
        sc.close();
    }
}

