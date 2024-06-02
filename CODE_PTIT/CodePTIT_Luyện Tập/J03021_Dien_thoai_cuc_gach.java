import java.util.Scanner;

public class J03021_Dien_thoai_cuc_gach {
    static char charValue (char x) {
        String s = "" + x;
        if (s.matches("[a-c]"))
            return '2';
        else if (s.matches("[d-f]"))
            return '3';
        else if (s.matches("[g-i]"))
            return '4';
        else if (s.matches("[j-l]"))
            return '5';
        else if (s.matches("[m-o]"))
            return '6';
        else if (s.matches("[p-s]"))
            return '7';
        else if (s.matches("[t-v]"))
            return '8';
        else    return '9';
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t-- > 0) {
            String res = "";
            char[] s = input.next().toLowerCase().toCharArray();
            for (char i : s)
                res += charValue(i);
            System.out.println(res.equals(new StringBuilder(res).reverse().toString()) ? "YES" : "NO");
        }
        input.close();
    }
}
