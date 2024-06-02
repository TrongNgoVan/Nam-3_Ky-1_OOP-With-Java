import java.io.*;
import java.util.*;

public class So_khong_giam {
    static int mapA[] = new int[(int) (1e5 + 5)];
    static int mapB[] = new int[(int) (1e5 + 5)];
    public static boolean isIncreasing (Integer x) {
        if (x < 10) return false;
        String s = x.toString();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i-1))    return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException, IOException {
        ArrayList<Integer> a = IOFile.read("DATA1.in");
        for (Integer i : a)
            if (isIncreasing(i))    mapA[i]++;
        a = IOFile.read("DATA2.in");
        for (Integer i : a)
            if (isIncreasing(i))    mapB[i]++;
        for (int i = 0; i < (int)1e5; i++)
            if (mapA[i] > 0 || mapB[i] > 0)
                System.out.println(i + " " + mapA[i] + " " + mapB[i]);
    }
}

class IOFile {
    public static <T> ArrayList<T> read (String file) throws IOException, ClassNotFoundException {
        ArrayList<T> list = new ArrayList<>();
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
        list = (ArrayList<T>) o.readObject();
        return list;
    }
}
