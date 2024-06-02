import java.util.*;
public class CTDL001 {
    static void printString (String s) {
        for (int i = 0; i < s.length(); i++)  
            System.out.print(s.charAt(i) + " ");
        System.out.println();
    }
    static boolean check (String s) {
        String s1 = new StringBuffer(s).reverse().toString();
        return s1.equals(s);
    }
    static void generate (int i, String s, int n) {
        if (i == n && check(s)) 
            printString(s);
        else if (i < n) {
            generate(i+1, s+"0", n);
            generate(i+1, s+"1", n);
        } 
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        generate(0, "", n);
        input.close();
    }
    
}
