import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        int maxLen = 1;
        int curr = 1;

        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                curr++;
            } else {
                curr = 1;
            }
            maxLen = Math.max(maxLen, curr);
        }

        System.out.println(maxLen);
        sc.close();
    }
}
