import java.util.*;
import java.io.*;

public class Ghep_ma {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        TreeSet<String> start = new TreeSet<>(IOFile.read("DATA1.in"));
        TreeSet<Integer> end = new TreeSet<>(IOFile.read("DATA2.in"));
        for (String i : start)
            for (Integer j : end)
                System.out.println(i + j);
    }
}

class IOFile {
    public static <T> ArrayList<T> read(String file) throws IOException, ClassNotFoundException {
        ArrayList<T> list = new ArrayList<>();
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
        list = (ArrayList<T>) o.readObject();
        return list;
    }
}
