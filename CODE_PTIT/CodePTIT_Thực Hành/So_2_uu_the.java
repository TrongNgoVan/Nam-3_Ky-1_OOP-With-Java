import java.util.*;

public class So_2_uu_the {
    public static boolean isValid (String s) {
        if (s.equals("") || s.charAt(0) == '0') return false;
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '2') ++count;
        return count > s.length()/2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            Queue<String> q = new LinkedList<>();
            q.add("");
            while(n > 0) {
                String s = q.poll();
                if (isValid(s)) {
                    System.out.print(s + " ");
                    --n;
                }
                q.add(s + "0");
                q.add(s + "1");
                q.add(s + "2");
            }
            System.out.println();
        }
        sc.close();
    }
}
