import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int c = sc.nextInt();
        int l = sc.nextInt();

        int max = Math.max(g, Math.max(c, l));
        int min = Math.min(g, Math.min(c, l));

        if (max - min >= 10) {
            System.out.println("check again");
        } else {
            // Find median
            int[] arr = {g, c, l};
            Arrays.sort(arr);
            int median = arr[1];   // middle element
            
            System.out.println("final " + median);
        }


    }
}