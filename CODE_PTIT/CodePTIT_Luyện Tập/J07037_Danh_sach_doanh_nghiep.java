import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class J07037_Danh_sach_doanh_nghiep {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<DN> dn = new ArrayList<>();
        while (n-- > 0) 
            dn.add(new DN(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine())));
        dn.sort((a, b) -> a.getId().compareTo(b.getId()));
        dn.forEach(System.out::println);
        sc.close();
    }
}

class DN {
    String id, name;
    Integer amount;

    public DN(String id, String name, Integer amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + amount;
    }

}