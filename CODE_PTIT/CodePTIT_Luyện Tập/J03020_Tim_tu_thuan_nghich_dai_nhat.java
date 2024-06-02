import java.util.*;

public class J03020_Tim_tu_thuan_nghich_dai_nhat {
    static boolean isReversible(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.next();
            if (isReversible(s)) {
                if (map.get(s) == null) map.put(s, 1);
                else    map.put(s, map.get(s) + 1);

                if ((list.isEmpty() || s.length() == list.get(0).length()) && !list.contains(s)) 
                    list.add(s);
                else if (!list.isEmpty() && s.length() > list.get(0).length()) {
                    list.clear();
                    list.add(s);
                }
            }
        }
        list.forEach(e -> System.out.println(e + " " + map.get(e)));
    }
}
