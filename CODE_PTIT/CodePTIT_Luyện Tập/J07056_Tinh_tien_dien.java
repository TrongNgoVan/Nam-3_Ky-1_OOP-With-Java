import java.util.*;
import java.io.*;

public class J07056_Tinh_tien_dien {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        ArrayList<Receipt> re = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++)   re.add(new Receipt(i, sc.nextLine(), sc.nextLine().trim().split("\\s+")));
        re.sort((a, b) -> b.getTotal() - a.getTotal());
        re.forEach(System.out::println);
    }
}

class Receipt {
    String id, name, type;
    int first, last, quota;

    public Receipt (int i, String name, String[] list) {
        this.id = String.format("KH%02d", i);
        this.name = formatName(name);
        this.type = list[0];
        this.first = Integer.parseInt(list[1]);
        this.last = Integer.parseInt(list[2]);
        this.quota = getQuota();
    }
    
    public int getQuota() {
        switch (type) {
            case "A": return 100;
            case "B": return 500;
            case "C": return 200;
        }
        return 0;
    }

    public String formatName(String name) {
        String[] list = name.trim().split("\\s+");
        for (int i = 0; i < list.length; i++)
            list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1).toLowerCase();
        return String.join(" ", list);
    }

    public int inQuota() {
        int electricNumber = last - first;
        return Math.min(quota, electricNumber) * 450;
    }

    public int overQuota() {
        int electricNumber = last-first;
        return electricNumber <= quota ? 0 : (electricNumber - quota) * 1000;
    }

    public int getVAT() {
        return (int) (overQuota()*0.05);
    }

    public int getTotal() {
        return (int) (inQuota() + overQuota() * 1.05);
    }
    @Override
    public String toString() {
        return id + " " + name + " " + inQuota() + " " + overQuota() + " " + getVAT() + " " + getTotal();
    }

}