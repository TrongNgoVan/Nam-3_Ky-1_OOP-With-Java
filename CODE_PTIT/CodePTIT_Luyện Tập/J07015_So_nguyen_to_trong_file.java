import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class J07015_So_nguyen_to_trong_file {
    public static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n < 5 || n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i <= Math.sqrt(n); i++)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ArrayList<Integer> list = IOFile.read("SONGUYEN.in");
        int[] map = new int[10005];
        for (Integer i : list)  map[i]++;
        for (int i = 0; i < 10000; i++)
            if (map[i] != 0 && isPrime(i))
                System.out.println(i + " " + map[i]);
    }
}

class IOFile {
    public static <T> ArrayList<T> read(String file) throws ClassNotFoundException, IOException {
        ArrayList<T> list = new ArrayList<>();
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
        list = (ArrayList<T>)   o.readObject();
        return list;
    }
}