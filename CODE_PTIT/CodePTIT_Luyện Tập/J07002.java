import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07002 {
    static public boolean isInteger(String s) {
        return s.length() <= 10 && s.matches("-?\\d+");
    }
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream myFile = new FileInputStream("DATA.in");
        Scanner input = new Scanner(myFile);
        long result = 0;
        while (input.hasNextLine()) {
            String[] word = input.nextLine().split("\\s+");
            for (String i : word)
                if (isInteger(i) && Integer.parseInt(i) <= Integer.MAX_VALUE)
                    result += Integer.parseInt(i);
        }
        System.out.println(result);
        input.close();
    }
}
