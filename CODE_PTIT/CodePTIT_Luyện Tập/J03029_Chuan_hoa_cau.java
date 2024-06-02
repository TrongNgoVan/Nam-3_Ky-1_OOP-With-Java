import java.util.*;

public class J03029_Chuan_hoa_cau {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(new File("test.in"));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().trim().toLowerCase().split("\\s+");
            s[0] = s[0].substring(0, 1).toUpperCase() + s[0].substring(1);
            String tmp = s[s.length-1];
            if (tmp.length() == 1 && (tmp.equals(".") || tmp.equals("!") || tmp.equals("?"))) {
                System.out.println(String.join(" ", Arrays.copyOfRange(s, 0, s.length-1)) + s[s.length-1]);
            }
            else if (tmp.matches("^.*(\\.|\\.|\\?)$")) 
                System.out.println(String.join(" ", s));
            else 
                System.out.println(String.join(" ", s) + ".");
        }
        sc.close();
    }
}
