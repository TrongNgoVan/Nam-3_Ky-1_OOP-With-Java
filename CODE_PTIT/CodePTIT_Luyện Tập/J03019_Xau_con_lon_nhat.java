import java.util.*;

public class J03019_Xau_con_lon_nhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        char[] c = sc.nextLine().toCharArray();
        for (int i = 0; i < c.length; i++) {
            while (!st.isEmpty() && c[i] > st.peek())
                st.pop();
            st.push(c[i]);
        }
        
        System.out.println(st.toString().replaceAll("\\[|\\]|\\s+|,", ""));
        sc.close();
    }
}
