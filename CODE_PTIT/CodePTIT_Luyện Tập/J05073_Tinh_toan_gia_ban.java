import java.util.*;


public class J05073_Tinh_toan_gia_ban {

     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] s = sc.nextLine().split("\\s+");
            System.out.println(new Item(s[0], Long.parseLong(s[1]), Long.parseLong(s[2])));
        }
        sc.close();
    }
}

class Item {
    private String id;
    private Long price, amount;

    public Item(String id, Long price, Long amount) {
        this.id = id;
        this.price = price;
        this.amount = amount;
    }

    private double getTaxPercent() {
        char s = id.charAt(0);
        if (s == 'T')
            return 29.0 / 100;
        if (s == 'C')
            return 10.0 / 100;
        if (s == 'D')
            return 8.0 / 100;
        if (s == 'M')
            return 2.0 / 100;
        return 0;
    }

    private double getDeliveryFee() {
        char s = id.charAt(0);
        if (s == 'T')
            return 4.0 / 100;
        if (s == 'C')
            return 3.0 / 100;
        if (s == 'D')
            return 2.5 / 100;
        if (s == 'M')
            return 0.5 / 100;
        return 0;
    }

    private double getTotalFee() {
        if (id.charAt(id.length() - 1) == 'C')
            return price * (1 + getDeliveryFee() + getTaxPercent() * 0.95) * 1.2;
        return price * (1 + getDeliveryFee() + getTaxPercent()) * 1.2;
    }

    @Override
    public String toString() {
        return id + " " + String.format("%.2f", getTotalFee()); 
    }

}