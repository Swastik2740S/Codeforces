import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String x = sc.next();    
            int digit = x.charAt(0) - '0';
            int len = x.length();

            int result = (digit - 1) * 10 + (len * (len + 1)) / 2;
            System.out.println(result);
        }

        sc.close();
    }
}
