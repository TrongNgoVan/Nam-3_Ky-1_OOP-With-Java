import java.util.*;

public class J03031_Xau_day_du {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            Set<Character> set = new HashSet<>();
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) 
                set.add(s.charAt(i));
            int k = Integer.parseInt(sc.nextLine());
            System.out.println(set.size() + k >= 26 ? "YES" : "NO");
        }
        sc.close();
    }
}
