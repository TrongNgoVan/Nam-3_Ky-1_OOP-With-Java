import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J07007 {
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}
class WordSet {
    String file;

    public WordSet (String file) {
        this.file = file;
    }

    public String solution() throws FileNotFoundException {
        FileInputStream path = new FileInputStream("VANBAN.in");
        Scanner input = new Scanner(path);
        Set <String> set = new TreeSet<String>();
        while (input.hasNextLine()) {
            String[] words = input.nextLine().split("\\s+");
            for (String word : words) {
                word = word.toLowerCase();
                set.add(word);
            }
        }
        input.close();
        StringBuilder res = new StringBuilder("");
        for (String s : set)
            res.append(s).append("\n");
        return res.toString().trim();
    }
    
    @Override
    public String toString() {
        try {
            return solution();
        } catch (FileNotFoundException e) {
            //TODO: handle exception
            return null;
        }
    }

}
