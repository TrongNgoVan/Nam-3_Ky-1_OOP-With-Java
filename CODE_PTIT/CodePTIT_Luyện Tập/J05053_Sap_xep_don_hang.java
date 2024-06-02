import java.util.*;

public class J05053_Sap_xep_don_hang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++)
            list.add(new Item(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()),
                    Integer.parseInt(sc.nextLine())));
        list.sort((a, b) -> a.getNumber().compareToIgnoreCase(b.getNumber()));
        list.forEach(System.out::println);
        sc.close();
    }
}

class Item {
    String name, id;
    int unitPrice, amount;

    public Item(String name, String id, int unitPrice, int amount) {
        this.name = name;
        this.id = id;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public String getNumber() {
        return id.substring(1, 4);
    }

    public int getDiscount() {
        if (id.endsWith("1"))
            return (int) Math.round(0.5 * unitPrice * amount);
        if (id.endsWith("2"))
            return (int) Math.round(0.3 * unitPrice * amount);
        return 0;
    }

    public int getMoney() {
        return amount * unitPrice - getDiscount();
    }

    @Override
    public String toString() {
        return name + " " + id + " " + getNumber() + " " + getDiscount() + " " + getMoney();
    }
}