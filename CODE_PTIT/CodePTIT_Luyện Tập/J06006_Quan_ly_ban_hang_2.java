import java.util.*;

public class J06006_Quan_ly_ban_hang_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Customer> cus = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            cus.add(new Customer(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));

        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Item> item = new ArrayList<>();
        for (int i = 1; i <= m; i++)
            item.add(new Item(i, sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()),
                    Integer.parseInt(sc.nextLine())));

        int k = Integer.parseInt(sc.nextLine());
        ArrayList<Receipt> re = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            String customerId = sc.next();
            String itemId = sc.next();
            Customer customerTemp = new Customer();
            Item itemTemp = new Item();
            for (Customer j : cus)
                if (customerId.equals(j.id))
                    customerTemp = j;
            for (Item j : item)
                if (itemId.equals(j.id))
                    itemTemp = j;
            re.add(new Receipt(i, customerTemp, itemTemp, Integer.parseInt(sc.next())));
        }
        re.sort((a, b) -> b.profit - a.profit);
        re.forEach(System.out::println);
        sc.close();
    }
}

class Customer {
    String id, name, gender, dob, address;

    public Customer() {
    }

    public Customer(int i, String name, String gender, String dob, String address) {
        this.id = "KH" + String.format("%03d", i);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

}

class Item {
    String id, name, unit;
    Integer purchase, sale;

    public Item() {
    }

    public Item(int i, String name, String unit, Integer purchase, Integer sale) {
        this.id = "MH" + String.format("%03d", i);
        this.name = name;
        this.unit = unit;
        this.purchase = purchase;
        this.sale = sale;
    }
}

class Receipt {
    String id;
    Customer customer;
    Item item;
    Integer amount;
    int profit;

    public Receipt(int i, Customer customer, Item item, Integer amount) {
        this.id = "HD" + String.format("%03d", i);
        this.customer = customer;
        this.item = item;
        this.amount = amount;
        this.profit = (item.sale - item.purchase) * amount;
    }

    @Override
    public String toString() {
        return id + " " + customer.name + " " + customer.address + " " + item.name + " " + amount + " "
                + item.sale * amount + " " + profit;
    }

}