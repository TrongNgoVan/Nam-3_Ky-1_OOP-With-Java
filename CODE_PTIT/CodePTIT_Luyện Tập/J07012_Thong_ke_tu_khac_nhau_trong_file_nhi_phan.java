import java.io.*;
import java.util.regex.*;
import java.util.*;

public class J07012_Thong_ke_tu_khac_nhau_trong_file_nhi_phan {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ArrayList<String> input= IOFile.read("DATA.in");
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String line : input) {
            Matcher matcher = Pattern.compile("\\w+").matcher(line.toLowerCase());
            while (matcher.find()) {
                String i = matcher.group();
                if (map.get(i) != null)
                    map.put(i, map.get(i) + 1);
                else {
                    map.put(i, 1);
                    list.add(i);
                }
            }
        }
        list.sort((a, b) -> map.get(b).compareTo(map.get(a)) == 0 ? a.compareTo(b) : map.get(b).compareTo(map.get(a)));
        list.forEach(e -> System.out.println(e + " " + map.get(e)));
    }
}

class IOFile {
    public static <T> ArrayList<T> read (String file) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
        ArrayList<T> list = (ArrayList<T>) o.readObject();
        return list;
    }
}