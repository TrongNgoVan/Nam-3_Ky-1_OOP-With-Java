import java.util.*;

public class J05048_Bang_theo_doi_nhap_xuat_hang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Product> arrayList = new ArrayList<>();

        while (t-- > 0) {
            arrayList.add(new Product(sc.next(), sc.nextInt()));
        }
        arrayList.forEach(System.out::println);
        sc.close();
    }
}
class Product{
    private String id;
    private int importQuantity;

    public Product(String id, int importQuantity) {
        this.id = id;
        this.importQuantity = importQuantity;
    }

    public String getId() {
        return id;
    }

    public int getExportQuantity(){
        if(id.startsWith("A")) return (int) Math.round(0.6 * importQuantity);
        if(id.startsWith("B")) return (int) Math.round(0.7 * importQuantity);
        return 0;
    }

    public int getUnitPrice(){
        if(id.endsWith("Y")) return 110000;
        if(id.endsWith("N")) return 135000;
        return 0;
    }

    public int getTotalPrice(){
        return getExportQuantity() * getUnitPrice();
    }

    public int getTariff(){
        if(id.startsWith("A") && id.endsWith("Y")) return (int) Math.round(0.08 * getTotalPrice());
        if(id.startsWith("A") && id.endsWith("N")) return (int) Math.round(0.11 * getTotalPrice());
        if(id.startsWith("B") && id.endsWith("Y")) return (int) Math.round(0.17 * getTotalPrice());
        if(id.startsWith("B") && id.endsWith("N")) return (int) Math.round(0.22 * getTotalPrice());
        return 0;
    }

    @Override
    public String toString() {
        return id + " " + importQuantity + " " + getExportQuantity() + " " + getUnitPrice() + " " + getTotalPrice() + " " + getTariff();
    }
}