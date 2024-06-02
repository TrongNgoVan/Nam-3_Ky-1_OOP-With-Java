import java.util.*;
import java.io.*;

public class J07032_So_thuan_nghich_trong_file {
    public static boolean isReverable (Integer n) {
        String s1 = n.toString();
        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.length() > 1 && s1.length() % 2 == 1 && s1.matches("^[13579]+$") && s1.equals(s2);
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> data1 = (ArrayList<Integer>) o.readObject();
        int[] m1 = new int[1000005];
        Arrays.fill(m1, 0);
        data1.forEach(e -> m1[e]++);

        o = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> data2 = (ArrayList<Integer>) o.readObject();
        int[] m2 = new int[1000005];
        Arrays.fill(m2, 0);
        data2.forEach(e -> m2[e]++);

        int cnt = 0;
        for (int i = 0; i <= 1000000; i++) {
            if (m1[i] > 0 && m2[i] > 0 && isReverable(i)) {
                System.out.println(i + " " + (m1[i] + m2[i]));
                cnt++;
            }
            if (cnt == 10)  break;
        }    
    }
}
