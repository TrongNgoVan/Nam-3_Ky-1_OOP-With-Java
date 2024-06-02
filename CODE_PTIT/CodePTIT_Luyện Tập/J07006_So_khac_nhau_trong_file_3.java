import java.util.*;
import java.io.*;

public class J07006_So_khac_nhau_trong_file_3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> data = (ArrayList<Integer>) o.readObject();
        int[] m = new int[1000005];
        Arrays.fill(m, 0);
        data.forEach(e -> m[e]++);
        for (int i = 0; i <= 1000; i++) {
            if (m[i] > 0) {
                System.out.println(i + " " + m[i]);
            }
        }
    }
}
