import java.util.*;
import java.io.*;

public class J07024_Hieu_cua_hai_tap_tu {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}

class WordSet {
    private TreeSet<String> set;

    public WordSet(String file) throws IOException {
        set = new TreeSet<>();
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNext())
            set.add(sc.next().toLowerCase());
    }

    public TreeSet<String> getSet() {
        return this.set;
    }

    public String difference (WordSet o) {
        TreeSet<String> set2 = o.getSet();
        TreeSet<String> res = new TreeSet<>();
        set.forEach(e -> {
            if (!set2.contains(e))
                res.add(e);
        });
        return String.join(" ", res);
    }
}