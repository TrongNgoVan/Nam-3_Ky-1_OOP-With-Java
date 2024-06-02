import java.util.ArrayList;
import java.util.Scanner;

public class J05081_Danh_sach_mat_hang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<Goods> arr = new ArrayList<>();
        for (int i = 1; i <= t; i++) {
            arr.add(new Goods(i, sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt()));
            sc.nextLine();
        }
        arr.sort((a, b) -> {
            if (a.profit != b.profit)
                return b.profit - a.profit;
            else return a.index - b.index;
        });
        arr.forEach(System.out::println);
        sc.close();
    }
}

class Goods {
    String id, name, unit;
    int purchase, sale, index, profit;

    public Goods(int index, String name, String unit, int purchase, int sale) {
        this.id = "MH" + String.format("%03d", index);
        this.name = name;
        this.unit = unit;
        this.purchase = purchase;
        this.sale = sale;
        this.index = index;
        this.profit = sale - purchase;
    }
    
    @Override
    public String toString() {
        return id + " " + name + " " + unit + " " + purchase + " " + sale + " " + profit;
    }
}