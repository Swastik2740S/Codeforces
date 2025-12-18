import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Your code here
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        sc.nextLine();
        int count = 0;

        while (testcase-- > 0) {
            String s = sc.nextLine();
            if(s.equals("++X") || s.equals("X++")) count++;
            else count--;
        }
        System.out.println(count);
    }
}