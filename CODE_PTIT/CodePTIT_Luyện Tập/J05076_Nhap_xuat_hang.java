import java.util.*;

public class J05076_Nhap_xuat_hang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new Item(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        int m = Integer.parseInt(sc.nextLine());
        while (m-- > 0) {
            String id = sc.next();
            list.forEach(e -> {
                if (id.equals(e.getId())) 
                    System.out.println(new Receipt(id, Integer.parseInt(sc.next()), Integer.parseInt(sc.next()), Integer.parseInt(sc.next()), e));
                
            });
        }
        sc.close();
    }
}

class Item {
    private String id, name, type;
    
    public Item(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public Integer getProfit () {
        switch (type) {
            case "A": return  8;
            case "B": return  5;
            case "C": return  2;
            default: return 0;
        }
    }
}

class Receipt {
    private String id;
    private Integer importAmount, importReceipt, exportAmount;
    private Item item;

    public Receipt(String id, Integer importAmount, Integer importReceipt, Integer exportAmount, Item item) {
        this.id = id;
        this.importAmount = importAmount;
        this.importReceipt = importReceipt;
        this.exportAmount = exportAmount;
        this.item = item;
    }

    @Override
    public String toString() {
        return id + " " + item.getName() + " " + importAmount * importReceipt + " " + (int)exportAmount * importReceipt * (100 + item.getProfit()) / 100;
    }
    
}
