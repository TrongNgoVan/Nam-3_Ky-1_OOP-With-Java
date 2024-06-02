import java.io.*;
import java.util.*;

public class J07029_So_nguyen_to_lon_nhat_trong_file {
    static int[] p = new int[(int)1e6 + 5];
    public static void sievePrime () {
        Arrays.fill(p, 0);
        p[0] = p[1] = 1;
        for (int i=2; i<=Math.sqrt(1000000); i++)
            for (int j=i*i; j<=1000000; j+=i)
                if (p[i]==0)
                    p[j] = 1;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        sievePrime();
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> data = (ArrayList<Integer>) o.readObject();
        int[] m = new int[(int)1e6 + 5];
        Arrays.fill(m, 0);
        data.forEach(e -> m[e]++);
        int count = 0;
        for (int i = 1000000; i >= 0; i--) {
            if (p[i] == 0 && m[i] > 0) {
                System.out.println(i + " " + m[i]);
                count++;
            }
            if (count == 10)    break;
        }
    }
}