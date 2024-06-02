import java.util.*;
import java.io.*;
import java.text.*;

public class J07049_Tinh_ngay_het_han_bao_hanh {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++)
            items.add(new Item(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()),
                    Integer.parseInt(sc.nextLine())));

        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = sc.nextLine(), address = sc.nextLine(), itemId = sc.nextLine();
            int amount = Integer.parseInt(sc.nextLine());
            String purchaseDate = sc.nextLine();
            Item item = new Item();
            for (Item it : items)
                if (it.getId().equals(itemId)) {
                    item = it;
                    break;
                }

            clients.add(new Client(i + 1, name, address, item, amount, purchaseDate));
        }

        clients.sort((a, b) -> {
            try {
                if (a.getExpirationDate().compareTo(b.getExpirationDate()) == 0)
                    return a.getId().compareTo(b.getId());
                return a.getExpirationDate().compareTo(b.getExpirationDate());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        clients.forEach(System.out::println);
        sc.close();
    }
}

class Item {
    private String id, name;
    private Integer price, guarantee;

    public Item() {
    }

    public Item(String id, String name, Integer price, Integer guarantee) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.guarantee = guarantee;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getGuarantee() {
        return guarantee;
    }
}

class Client {
    private String id, name, address;
    private Item item;
    private Integer amount;
    private String purchaseDate;

    public Client(int id, String name, String address, Item item, Integer amount, String date) {
        this.id = String.format("KH%02d", id);
        this.name = name;
        this.address = address;
        this.item = item;
        this.amount = amount;
        this.purchaseDate = date;
    }

    public String getId() {
        return id;
    }

    public Date getExpirationDate() throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(purchaseDate);
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        time.add(Calendar.MONTH, item.getGuarantee());
        return time.getTime();
    }

    private String getExpirationString() throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").format(getExpirationDate());
    }

    private long getTotal() {
        return amount * item.getPrice();
    }

    @Override
    public String toString() {
        try {
            return String.format("%s %s %s %s %d %s", id, name, address, item.getId(), getTotal(),
                    getExpirationString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}