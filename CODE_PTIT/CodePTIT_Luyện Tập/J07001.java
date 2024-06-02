import java.io.File;
import java.util.Scanner;

public class J07001 {
    public static void main(String[] args) {
        try {
            File myFile = new File("DATA.in");
            Scanner input = new Scanner(myFile);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
