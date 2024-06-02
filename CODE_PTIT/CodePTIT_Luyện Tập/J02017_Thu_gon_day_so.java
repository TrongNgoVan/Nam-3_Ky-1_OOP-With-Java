import java.util.Scanner;
import java.util.Stack;

public class J02017_Thu_gon_day_so {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     List<Integer> a = new ArrayList<>();
    //     for (int i = 0; i < n; i++)
    //         a.add(sc.nextInt());
    //     boolean isValid = false;
    //     while (!isValid && a.size() >= 2) {
    //         isValid = true;
    //         for (int i = 1; i < a.size(); i++) 
    //             if ((a.get(i) + a.get(i-1)) % 2 == 0) {
    //                 a.remove(i);
    //                 a.remove(i-1);
    //                 isValid = false;
    //                 break;
    //             }
    //     }
    //     System.out.println(a.size());
    // }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        Stack<Integer> s=new Stack<>();
        s.push(a[0]);
        int i=1;
        while(i<n){
            if(s.size()>0){
                int tmp=s.peek();
                if((tmp+a[i])%2==0){
                    s.pop();
                }
                else{
                    s.push(a[i]);
                }
            }
            else{
                s.push(a[i]);
            }
            i++;
        }
        System.out.println(s.size());
        sc.close();
    }
}
