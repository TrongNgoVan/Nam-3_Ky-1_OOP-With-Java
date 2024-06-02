import java.util.*;

public class J05010_Sap_xep_danh_sach_mat_hang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> item = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++)
            item.add(new Item(sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()),
                    Float.parseFloat(sc.nextLine()), i));
        item.sort((a, b) -> -a.profit.compareTo(b.profit));
        item.forEach(System.out::println);
        sc.close();
    }
}

class Item {
    String name, type;
    Integer id;
    Float purchase, sale, profit;

    public Item(String name, String type, Float purchase, Float sale, Integer i) {
        this.name = name;
        this.type = type;
        this.purchase = purchase;
        this.sale = sale;
        this.id = i;
        this.profit = sale - purchase;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + type + " " + String.format("%.2f", profit);
    }

}
