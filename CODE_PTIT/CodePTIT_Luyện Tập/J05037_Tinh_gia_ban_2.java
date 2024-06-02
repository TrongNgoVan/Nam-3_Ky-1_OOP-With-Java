import java.util.*;

public class J05037_Tinh_gia_ban_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(new Item(i + 1, sc.next(), sc.next(), sc.nextInt(), sc.nextInt()));
        }
        list.sort((a, b) -> b.onSale() - a.onSale());
        list.forEach(System.out::println);
        sc.close();
    }
}

class Item {
    String id;
    String name, unit;
    int purchase, amount;

    public Item(int id, String name, String unit, int purchase, int amount) {
        this.id = String.format("MH%02d", id);
        this.name = name;
        this.unit = unit;
        this.purchase = purchase;
        this.amount = amount;
    }

    public int shippingFee() {
        return (int) Math.round(0.05 * (purchase * amount));
    }

    public int total() {
        return purchase * amount + shippingFee();
    }

    public int onSale() {
        return (int) Math.ceil((1.02 * total() / amount) / 100) * 100;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + unit + " " + shippingFee() + " " + total() + " " + onSale();
    }

}