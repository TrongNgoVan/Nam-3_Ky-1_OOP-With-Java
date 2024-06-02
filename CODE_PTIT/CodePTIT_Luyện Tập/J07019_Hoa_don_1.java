import java.util.*;
import java.io.*;

public class J07019_Hoa_don_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("DATA1.in"));
        ArrayList<Item> list = new ArrayList<>();
        int n = Integer.parseInt(sc1.nextLine());
        for (int i = 1; i <= n; i++)
            list.add(new Item(sc1.nextLine(), sc1.nextLine(), Long.parseLong(sc1.nextLine()),
                    Long.parseLong(sc1.nextLine())));
        
        Scanner sc2 = new Scanner(new File("DATA2.in"));
        int m = Integer.parseInt(sc2.nextLine());
        for (int i = 1; i <= m; i++) {
            String id = sc2.next();
            String itemId = id.substring(0, 2);
            long amount = Long.parseLong(sc2.next());
            for (Item e : list) {
                if (itemId.equals(e.getId()))
                    System.out.println(new Receipt(id, i, amount, e));
            }
        }
        sc1.close();
        sc2.close();
    }
}

class Item {
    private String id, name;
    private Long type1, type2;

    public Item(String id, String name, Long type1, Long type2) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
    }

    public String getId() {
        return this.id;
    }

    public Long getType1() {
        return this.type1;
    }

    public Long getType2() {
        return this.type2;
    }

    public String getName() {
        return this.name;
    }

}

class Receipt {
    private String id;
    private Long amount;
    private Item item;

    public Receipt(String id, int stt, Long amount, Item item) {
        this.id = String.format("%s-%03d", id, stt);
        this.amount = amount;
        this.item = item;
    }

    public Integer getDiscountPercent() {
        if (amount >= 150)
            return 50;
        if (amount >= 100)
            return 30;
        if (amount >= 50)
            return 15;
        return 0;
    }

    public long getPrice() {
        return amount * (id.charAt(2) == '1' ? item.getType1() : item.getType2());
    }

    public long getDiscount() {
        return (long) getPrice() * getDiscountPercent() / 100;
    }

    public long getTotal() {
        return getPrice() - getDiscount();
    }

    @Override
    public String toString() {
        return id + " " + item.getName() + " " + getDiscount() + " " + getTotal();
    }

}