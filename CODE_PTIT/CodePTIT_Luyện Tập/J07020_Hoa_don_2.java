import java.util.*;
import java.io.*;

public class J07020_Hoa_don_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("KH.in"));

        int n = Integer.parseInt(sc1.nextLine());
        ArrayList<Customer> cus = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            cus.add(new Customer(i, sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));

        Scanner sc2 = new Scanner(new File("MH.in"));
        int m = Integer.parseInt(sc2.nextLine());
        ArrayList<Item> item = new ArrayList<>();
        for (int i = 1; i <= m; i++)
            item.add(new Item(i, sc2.nextLine(), sc2.nextLine(), Integer.parseInt(sc2.nextLine()),
                    Integer.parseInt(sc2.nextLine())));

        Scanner sc3 = new Scanner(new File("HD.in"));
        int k = Integer.parseInt(sc3.nextLine());
        ArrayList<Receipt> re = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            String customerId = sc3.next();
            String itemId = sc3.next();
            Customer customerTemp = new Customer();
            Item itemTemp = new Item();
            for (Customer j : cus)
                if (customerId.equals(j.id))
                    customerTemp = j;
            for (Item j : item)
                if (itemId.equals(j.id))
                    itemTemp = j;
            re.add(new Receipt(i, customerTemp, itemTemp, Integer.parseInt(sc3.next())));
        }

        for (Receipt receipt : re)
            System.out.println(receipt);
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

    public Receipt(int i, Customer customer, Item item, Integer amount) {
        this.id = "HD" + String.format("%03d", i);
        this.customer = customer;
        this.item = item;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return id + " " + customer.name + " " + customer.address + " " + item.name + " " + item.unit + " "
                + item.purchase + " " + item.sale + " " + amount + " " + item.sale * amount;
    }

}