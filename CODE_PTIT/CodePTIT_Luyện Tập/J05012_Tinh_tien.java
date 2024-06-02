import java.util.*;

public class J05012_Tinh_tien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        ArrayList<Items> list = new ArrayList<>();
        while (t-- > 0) {
            sc.nextLine();
            list.add(new Items(sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong(), sc.nextLong()));
        }

        list.sort((a, b) -> b.getTotalPrice().compareTo(a.getTotalPrice()));
        list.forEach(System.out::println);

        sc.close();
    }
}

class Items {
    private String id;
    private String name;
    private long quantity;
    private long unitPrice;
    private long discount;

    public Items(String id, String name, long quantity, long unitPrice, long discount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public Long getTotalPrice() {
        return unitPrice * quantity - discount;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + quantity + " " + unitPrice + " " + discount + " " + getTotalPrice();
    }
}