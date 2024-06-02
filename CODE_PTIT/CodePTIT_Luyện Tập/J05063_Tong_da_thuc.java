
import java.util.*;


public class J05063_Tong_da_thuc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }

}

class DaThuc {
    private TreeMap<Integer, Integer> map;

    public DaThuc(String s) {
        map = new TreeMap<>();
        String[] tmp = s.split("\\D+");
        for (int i = 0; i < tmp.length; i += 2)
            map.put(Integer.parseInt(tmp[i + 1]), Integer.parseInt(tmp[i]));
    }

    public DaThuc(TreeMap<Integer, Integer> map) {
        this.map = map;
    }

    public TreeMap<Integer, Integer> getMap() {
        return map;
    }

    public DaThuc cong(DaThuc o) {
        TreeMap<Integer, Integer> map2 = o.getMap();
        map.forEach((key, value) -> map2.merge(key, value, Integer::sum));
        return new DaThuc(map2);
    }

    @Override
    public String toString() {
        String res = "";
        for (Integer i : map.descendingKeySet()) {
            res += String.format("%d*x^%d ", map.get(i), i);
        }
        return res.trim().replaceAll(" ", " + "); // Generated from
                                                  // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
