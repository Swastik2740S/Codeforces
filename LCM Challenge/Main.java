import java.util.*;

public class Main {

    
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    
    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long lcm3(long a, long b, long c) {
        return lcm(lcm(a, b), c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        // Small edge cases
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }
        if (n == 3) {
            System.out.println(6);
            return;
        }

        long ans;

        if (n % 2 == 1) {
           
            ans = lcm3(n, n - 1, n - 2);
        } else {
           
            long option1 = lcm3(n, n - 1, n - 2);
            long option2 = lcm3(n - 1, n - 2, n - 3);
            ans = Math.max(option1, option2);
        }

        System.out.println(ans);
    }
}
