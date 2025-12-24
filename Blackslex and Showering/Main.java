import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            long original = 0;
            long bestSaving = 0;

            
            for (int i = 0; i < n - 1; i++) {
                long diff = Math.abs(a[i] - a[i + 1]);
                original += diff;

    
                if (i == 0 || i == n - 2) {
                    bestSaving = Math.max(bestSaving, diff);
                }
            }


            for (int i = 1; i < n - 1; i++) {
                long saving =
                        Math.abs(a[i] - a[i - 1]) +
                        Math.abs(a[i] - a[i + 1]) -
                        Math.abs(a[i - 1] - a[i + 1]);

                bestSaving = Math.max(bestSaving, saving);
            }

            out.append(original - bestSaving).append('\n');
        }

        System.out.print(out.toString());
    }
}
