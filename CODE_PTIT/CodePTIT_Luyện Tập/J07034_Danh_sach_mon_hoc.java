import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class J07034_Danh_sach_mon_hoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<MH> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new MH(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        list.sort((a, b) -> {
            return a.getName().compareTo(b.getName());
        });
        list.forEach(System.out::println);
    }
}

class MH {
    private String id;
    private String name;
    private int nums;

    public MH() {
    }

    public MH(String id, String name, int nums) {
        this.id = id;
        this.name = name;
        this.nums = nums;
    }

    public int getNums() {
        return nums;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + nums;
    }
}
