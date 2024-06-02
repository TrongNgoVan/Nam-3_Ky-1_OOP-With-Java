import java.io.*;

public class J07005_So_khac_nhau_trong_file_2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataInputStream sc = new DataInputStream(new FileInputStream("DATA.IN"));
        int[] map = new int[1005];
        for (int i = 0; i < 100000; i++) {
            map[sc.readInt()]++;
        }
        for (int i = 0; i < 1000; i++) {
            if (map[i] > 0) {
                System.out.println(i + " " + map[i]);
            }
        }
        sc.close();
    }
}
