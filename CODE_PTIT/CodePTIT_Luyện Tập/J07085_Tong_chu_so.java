import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class J07085_Tong_chu_so {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> list = (ArrayList<String>) o.readObject();
        list.forEach(e -> {
            String num = "";
            int sum = 0;
            for (int i = 0; i < e.length(); i++) 
                if (e.charAt(i) >= '0' && e.charAt(i) <= '9') {
                    num += e.charAt(i);
                    sum += e.charAt(i) - '0';
                }
                    
            System.out.println(new BigInteger(num) + " " + sum);
        });
        o.close();
    }
}

