import java.util.Scanner;
import java.util.Stack;

public class J03027_Rut_gon_xau_ky_tu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        Stack<Character> st = new Stack<>();
        for (char i : s) {
            if (!st.empty() && st.peek() == i) 
                st.pop();
            else st.push(i);
        }
        System.out.println(st.empty() ? "Empty String" : st.toString().replaceAll("(\\[|\\]|\\s+|,)", ""));
        sc.close();
    }
}
