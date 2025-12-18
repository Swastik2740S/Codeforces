import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long input = sc.nextLong(); 
        long newnumber = 0;

        int i = 0;
        while (input > 0) {
            long lastdigit = input % 10;

            long chosen;
            if (input < 10 && (9 - lastdigit) == 0) {
                chosen = lastdigit;
            } else {
                chosen = Math.min(lastdigit, 9 - lastdigit);
            }

            newnumber += chosen * (long) Math.pow(10, i);

            i++;
            input = input / 10;
        }

        System.out.println(newnumber);
    }
}
