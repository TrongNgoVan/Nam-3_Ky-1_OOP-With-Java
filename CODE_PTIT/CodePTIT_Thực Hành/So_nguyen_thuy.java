import java.util.*;

public class So_nguyen_thuy {
    public static String reversible (String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return s + s2;
    }
    public static void solution (int n) {
        Queue<String> q = new LinkedList<>();
        q.add("");
        String tmp = q.poll();
        while (n > 0) { 
            System.out.print(reversible(tmp + "4") + " ");
            q.add(tmp + "4");
            n--;
            if (n > 0) {
                System.out.print(reversible(tmp + "5") + " ");
                q.add(tmp + "5");
                n--;
            }            
            tmp = q.poll();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            solution(n);
            System.out.println();
        }
        sc.close();
    }
}
