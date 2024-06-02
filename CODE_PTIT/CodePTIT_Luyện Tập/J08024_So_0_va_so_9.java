import java.util.*;

public class J08024_So_0_va_so_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            Queue<String> q = new LinkedList<>();
            q.add("9");
            String tmp = q.poll();
            while (Long.parseLong(tmp) % n != 0) {
                q.add(tmp + "0");
                q.add(tmp + "9");
                tmp = q.poll();
            }
            System.out.println(tmp);
        }
        sc.close();
    }
}
