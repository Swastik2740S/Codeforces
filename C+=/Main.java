import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long n = sc.nextLong();

            int operations = 0;

            while (Math.max(a, b) <= n) {
                if (a < b) {
                    a += b;
                } else {
                    b += a;
                }
                operations++;
            }

            System.out.println(operations);
        }

        sc.close();
    }
}
