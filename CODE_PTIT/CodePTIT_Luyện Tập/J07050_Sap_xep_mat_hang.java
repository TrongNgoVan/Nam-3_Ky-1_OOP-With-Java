import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class J07050_Sap_xep_mat_hang {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        ArrayList<Product> res = new ArrayList<>();
        int n = Integer.valueOf(sc.nextLine());
        for (int i = 1; i <= n; i++) 
            res.add(new Product(i, sc.nextLine(), sc.nextLine(), Double.valueOf(sc.nextLine()), Double.valueOf(sc.nextLine())));
        res.sort((a, b) -> (int)(b.getProfit() - a.getProfit()));
        res.forEach(System.out::println);
        sc.close();
    }
}

class Product {
    String id, name, group;
    Double purchase, sale, profit;

    public Product(int stt, String name, String group, Double purchase, Double sale) {
        this.id = "MH" + String.format("%02d", stt);
        this.name = name;
        this.group = group;
        this.purchase = purchase;
        this.sale = sale;
        this.profit = sale - purchase;
    }

    public Double getProfit() {
        return this.profit;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + group + " " + String.format("%.2f", profit);
    }

}