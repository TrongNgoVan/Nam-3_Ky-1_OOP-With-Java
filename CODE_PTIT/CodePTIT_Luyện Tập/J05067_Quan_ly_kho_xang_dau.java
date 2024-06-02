import java.util.*;

public class J05067_Quan_ly_kho_xang_dau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Order> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++)
            list.add(new Order(sc.next(), Long.parseLong(sc.next())));
        list.forEach(System.out::println);
        sc.close();
    }
}

class Order {
    String id;
    long amount;


    public Order(String id, long amount) {
        this.id = id;
        this.amount = amount;
    }


    public String getBrand() {
        switch(id.substring(id.length()-2)) {
            case "BP": return "British Petro";
            case "ES":  return "Esso";
            case "SH":  return "Shell";
            case "CA":  return "Castrol";
            case "MO":  return "Mobil";
            default:    return "Trong Nuoc";
        }
    }

    public long getUnitPrice() {
        switch(id.substring(0, 1)) {
            case "X":   return 128000;
            case "D":   return 11200;
            case "N":   return 9700;
            default:    return 0;
        }
    }

    public long getTax() {
        if (id.substring(id.length() - 2).equals("TN"))   return 0;
        switch(id.substring(0, 1)) {
            case "X":   return 3840 * amount;
            case "D":   return 392 * amount;
            case "N":   return 194 * amount;
            default:    return 0;
        }
    }

    public long getTotal() {
        return getUnitPrice() * amount + getTax();
    }

    @Override
    public String toString() {
        return id + " " + getBrand() + " " + getUnitPrice() + " " + getTax() + " " + getTotal();
    }

}