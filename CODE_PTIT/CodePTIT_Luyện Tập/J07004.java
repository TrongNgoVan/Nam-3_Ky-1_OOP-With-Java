import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class J07004 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream path = new FileInputStream("DATA.in");
        Scanner input = new Scanner(path);
        Map <Integer, Integer> map = new TreeMap<Integer, Integer>();
        while (input.hasNextInt()) {
            int num = input.nextInt();
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                map.put(num, count);
            }
            else map.put(num, 1);
        }
        for (Integer key : map.keySet()) 
            System.out.println(key + " " + map.get(key));
        input.close();
    }
}
