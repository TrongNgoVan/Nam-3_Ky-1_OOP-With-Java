import java.util.*;
import java.io.*;

public class J07016_So_nguyen_to_trong_hai_file_nhi_phan {
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
        list1.forEach(e -> map1[e]++);
        

        ArrayList<Integer> list2 = IOFile.read("DATA2.in");
        int[] map2 = new int[10005];
        Arrays.fill(map2, 0);
        list2.forEach(e -> map2[e]++);
        

        for (int i = 0; i <= 10000; i++) 
            if (map1[i] > 0 && map2[i] > 0 && isPrime(i)) {
                System.out.println(i + " " + map1[i] + " " + map2[i]);
            }
        
    }
}


class IOFile {
    public static <T> ArrayList<T> read (String file) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
        ArrayList<T> list = (ArrayList<T>) o.readObject();
        return list;
    }
}
