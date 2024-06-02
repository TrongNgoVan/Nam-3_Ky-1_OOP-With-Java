import java.io.*;
import java.util.*;

public class Thiet_lap_dia_chi_email_2 {
    public static String formatName (String s) {
        String[] tmp = s.toLowerCase().trim().split("\\s+");
        return String.join(" ", tmp);
    }
    public static String formatToEmail (String s) {
        String[] tmp = s.toLowerCase().trim().split("\\s+");
        String res = tmp[tmp.length - 1];
        for (int i = 0; i < tmp.length - 1; i++)
            res += tmp[i].substring(0, 1);
        return res;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> nameList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String name = formatName(sc.nextLine());
            if (nameList.contains(name))    continue;
            nameList.add(name);
            String res = formatToEmail(name);
            if (!map.containsKey(res)) {
                map.put(res, 1);
                System.out.println(res + "@ptit.edu.vn");
            } else {
                map.put(res, map.get(res) + 1);
                System.out.println(res + map.get(res) + "@ptit.edu.vn");
            }
        }
    }
}
