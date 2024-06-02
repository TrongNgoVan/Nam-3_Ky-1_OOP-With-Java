import java.io.*;
import java.util.*;


public class J07045_Loai_phong {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}

class LoaiPhong implements Comparable<LoaiPhong> {
    String line, name;

    public LoaiPhong(String line) {
        this.name = line.trim().split("\\s+")[1];
        this.line = line;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return line;
    }

    @Override
    public int compareTo(LoaiPhong o) {
        return name.compareTo(o.getName());
    }

}