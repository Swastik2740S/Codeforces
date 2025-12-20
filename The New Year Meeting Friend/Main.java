import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        int x = sc.nextInt();
        arr[0] = x;
        int y = sc.nextInt();
        arr[1] = y;
        int z = sc.nextInt();
        arr[2] = z;

        Arrays.sort(arr);
        int result = 0;
        result += Math.abs(arr[1] - arr[0]);
        result += Math.abs(arr[1] - arr[2]);

        System.out.println(result);
        
    }
}