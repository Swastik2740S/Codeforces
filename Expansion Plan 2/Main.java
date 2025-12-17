import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            String s = sc.next();

            long a = 0; // count of '8' (L∞ expansions)
            long b = 0; // count of '4' (L1 expansions)

            for (char c : s.toCharArray()) {
                if (c == '8') a++;
                else b++;
            }

            long u = Math.abs(x);
            long v = Math.abs(y);

            // distance from (u,v) to the square of radius a
            long dx = Math.max(0, u - a);
            long dy = Math.max(0, v - a);

            long dist = dx + dy;

            System.out.println(dist <= b ? "YES" : "NO");
        }
    }
}
