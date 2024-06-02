import java.io.*;
import java.util.*;

public class Danh_sach_mon_thi_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        ArrayList<Subjects> list = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();
        while(sc.hasNextLine()) {
            Subjects sj = (new Subjects(sc.nextLine(), sc.nextLine(), sc.nextLine()));
            String id = sj.id;
            if (!idList.contains(id)) {
                idList.add(id);
                list.add(sj);
            }
        }
        list.sort((a, b) -> a.getId().compareTo(b.getId()));
        list.forEach(System.out::println);
    }
}

class Subjects {
    String id, name, format;

    public String getId() {
        return this.id;
    }

    public Subjects(String id, String name, String format) {
        this.id = id;
        this.name = name;
        this.format = format;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + format;
    }

}