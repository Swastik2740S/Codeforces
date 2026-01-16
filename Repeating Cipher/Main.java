import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String t = sc.next();

        StringBuilder s = new StringBuilder();
        int i = 0;
        int k = 1;

        while (i < n) {
            s.append(t.charAt(i));
            i += k;
            k++;
        }

        System.out.println(s.toString());
    }
}
