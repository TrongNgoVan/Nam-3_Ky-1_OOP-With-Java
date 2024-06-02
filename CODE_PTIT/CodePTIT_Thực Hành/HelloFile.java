import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloFile {
    public static void main(String[] args) {
        try {
            File myFile = new File ("Hello.txt");
            Scanner input = new Scanner(myFile);
            while (input.hasNextLine()) {
                String data = input.nextLine();
                System.out.println(data);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
