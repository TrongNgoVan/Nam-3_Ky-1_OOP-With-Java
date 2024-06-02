import java.util.HashMap;
import java.util.Scanner;

public class J03010_Dia_chi_email {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] s = sc.nextLine().trim().toLowerCase().split("\\s+");
            String res = s[s.length-1];
            for (int i = 0; i < s.length -1; i++)
                res += s[i].charAt(0);
            if (!map.containsKey(res)) {
                map.put(res, 1);
                System.out.println(res + "@ptit.edu.vn");
            }
            else {
                map.put(res, map.get(res) + 1);
                System.out.println(res + map.get(res) + "@ptit.edu.vn");
            }
        }
        sc.close();
    }
}
