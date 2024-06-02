import java.util.Scanner;


public class J03040_Bien_so_dep {
    static long count (String s, char match) {
        return s.chars().filter(ch -> ch == match).count();
    }
    static boolean isBeauty (String s) {
        boolean isIncrease = true;
        for (int i = 1; i < s.length(); i++) 
            if (s.charAt(i) <= s.charAt(i-1)){ 
                isIncrease = false;
            }
        return (s.charAt(0) == s.charAt(1) && s.charAt(0) == s.charAt(2) && s.charAt(3) == s.charAt(4)) ||
        isIncrease || count(s, s.charAt(0)) == 5 || count(s, '6') + count(s, '8') == 5;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next().substring(5).replaceAll("\\.", ""); 
            System.out.println(isBeauty(s) ? "YES" : "NO");
        }
        sc.close();
    }
}
