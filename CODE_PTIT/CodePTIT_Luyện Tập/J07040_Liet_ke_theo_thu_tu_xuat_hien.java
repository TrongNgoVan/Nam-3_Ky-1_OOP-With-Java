import java.io.*;
import java.util.*;

public class J07040_Liet_ke_theo_thu_tu_xuat_hien {
    public static void main(String[] args) throws Exception {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        ArrayList<String> arr1  = (ArrayList<String>) input.readObject();
        HashMap<String, Integer> map = new HashMap<>();
        arr1.forEach(e -> {
            String[] tmp = e.trim().toLowerCase().split("\\s+");
            for (String i : tmp)
                map.put(i, 1);
        });

        Scanner sc = new Scanner(new File("VANBAN.in"));
        HashMap<String, Integer> map2 = new HashMap<>();
        while (sc.hasNext()) {
            String e = sc.next().trim().toLowerCase();
            if (map.get(e) != null && map2.get(e) == null) {
                System.out.println(e);
                map2.put(e, 1);
            }
        }
    }
}