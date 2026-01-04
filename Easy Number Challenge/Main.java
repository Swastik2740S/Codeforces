import java.util.*;

public class Main {
    static final int MAX = 1_000_000;
    static final int MOD = 1 << 30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] div = new int[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j += i) {
                div[j]++;
            }
        }

        long ans = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    ans += div[i * j * k];
                }
            }
        }

        System.out.println(ans % MOD);
    }
}
