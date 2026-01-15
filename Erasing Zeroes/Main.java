import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String s = sc.nextLine();

            int first = s.indexOf('1');
            int last = s.lastIndexOf('1');

            // If there are no 1s or only one 1
            if (first == -1 || first == last) {
                System.out.println(0);
                continue;
            }

            int count = 0;
            for (int i = first; i <= last; i++) {
                if (s.charAt(i) == '0') {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
