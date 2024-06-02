import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Kiem_tra_chia_het {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SONGUYEN.IN"));
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            Number n = new Number(sc.nextLine());
            System.out.println(n);
        }
        sc.close();
    }
}

class Number {
    BigInteger value;

    public Number(String s) {
        this.value = new BigInteger(s);
    }

    public int mod (int n) {
        BigInteger m = BigInteger.valueOf(n);
        BigInteger div = value.divide(m);
        return value.compareTo(div.multiply(m));
    }
    
    @Override
    public String toString () {
        if (mod(7) == 0 && mod(13) == 0)    return "Both";
        if (mod(13) == 0)  return "Div 13";
        if (mod(7) == 0)  return "Div 7";
        return "None";
    }
}
