import java.util.*;

public class J04022_Wordset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
        in.close();
    }
}

class WordSet {
    String[] s;
    TreeSet<String> set;

    public WordSet(String input) {
        this.s = input.toLowerCase().trim().split("\\s+");
        this.set = new TreeSet<>();
        for (String i : this.s)
            this.set.add(i);
    }

    public String[] getS() {
        return this.s;
    }

    public TreeSet<String> getSet() {
        return this.set;
    }

    public String union(WordSet a) {
        TreeSet<String> union = new TreeSet<>(set);
        for (String i : a.getSet())
            union.add(i);
        return String.join(" ", union);
    }

    public String intersection(WordSet a) {
        TreeSet<String> inter = new TreeSet<>();
        for (String i : set)
            if (a.getSet().contains(i))
                inter.add(i);
        return String.join(" ", inter);
    }
}
