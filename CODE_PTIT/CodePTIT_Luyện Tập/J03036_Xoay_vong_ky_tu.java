import java.util.*;

public class J03036_Xoay_vong_ky_tu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLine().toCharArray();
        long res = (long)1e18;
        for (char[] s0 : arr) {
            for (int i = 0; i < s0.length; i++) {
                long tmp = 0;
                boolean isValid = false;
                for (char[] s1 : arr) {
                    char[] tmpArr = s1.clone();
                    for (int j = 0; j < s1.length; j++) {
                        if (Arrays.equals(tmpArr, s0)) {
                            tmp += j;
                            isValid = true;
                            break;
                        }
                        char c = tmpArr[0];
                        for (int k = 0; k < tmpArr.length - 1; k++) 
                            tmpArr[k] = tmpArr[k+1];
                        tmpArr[tmpArr.length - 1] = c;
                    }
                    if (!isValid) {
                        System.out.println(-1);
                        return;
                    }
                }
                res = Math.min(res, tmp);
            }
        }
        System.out.println(res);
        sc.close();
    }
}
