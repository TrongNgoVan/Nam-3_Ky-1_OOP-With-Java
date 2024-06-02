import java.util.*;

public class J08011_Liet_ke_va_dem {
    public static boolean isIncreasing(String n) {
        for (int i = 1; i < n.length(); i++)
            if (n.charAt(i) < n.charAt(i-1))    return false;
        return true;
    }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            String n = sc.next();
            if (isIncreasing(n)) {
                if (map.get(n) != null) map.put(n, map.get(n) + 1);
                else {
                    map.put(n, 1);
                    list.add(n);
                }
            }
        }
        list.sort((a, b) -> map.get(b) - map.get(a));
        list.forEach(e -> System.out.println(e + " " + map.get(e)));
        sc.close();
    }
}
