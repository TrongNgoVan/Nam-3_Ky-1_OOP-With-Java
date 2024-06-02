import java.io.*;
import java.util.*;
import java.util.regex.*;

public class J07011_Thong_ke_tu_khac_nhau_trong_file_van_ban {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            // String[] s = sc.nextLine().toLowerCase().split("\\W+");
            Matcher matcher = Pattern.compile("\\w+").matcher(sc.nextLine().toLowerCase());
            while (matcher.find()) {
                String i = matcher.group();
                if (map.get(i) != null)
                    map.put(i, map.get(i) + 1);
                else {
                    map.put(i, 1);
                    list.add(i);
                }
            }
        }
        list.sort((a, b) -> map.get(b).compareTo(map.get(a)) == 0 ? a.compareTo(b) : map.get(b).compareTo(map.get(a)));
        list.forEach(e -> System.out.println(e + " " + map.get(e)));
        sc.close();
    }
}
