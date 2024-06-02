import java.io.*;
import java.util.*;

public class J07023_Nguyen_to_va_thuan_nghich {
    public static boolean isReverable(Integer n) {
        String s1 = n.toString();
        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.equals(s2);
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n % 2 == 0 && n > 2)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        ArrayList<Integer> list1 = IOFile.read("DATA1.in");
        int[] map1 = new int[10005];
        Arrays.fill(map1, 0);
        for (Integer i : list1) 
            map1[i]++;
        

        ArrayList<Integer> list2 = IOFile.read("DATA2.in");
        int[] map2 = new int[10005];
        Arrays.fill(map2, 0);
        for (Integer i : list2) 
            map2[i]++;
        

        for (int i = 0; i <= 10000; i++) {
            if (map1[i] > 0 && map2[i] > 0 && isPrime(i) && isReverable(i)) {
                System.out.println(i + " " + map1[i] + " " + map2[i]);
            }
        }
    }
}

class IOFile {
    public static <T> ArrayList<T> read(String file) throws ClassNotFoundException, IOException {
        ArrayList<T> list = new ArrayList<>();
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
        list = (ArrayList<T>) o.readObject();
        return list;
    }
}