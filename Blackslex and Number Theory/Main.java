import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while(testcase-- >0){
            int size = sc.nextInt();
            int[] arr = new int[size];

            for(int i=0;i<size;i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            System.out.println(Math.max(arr[0] , arr[1]-arr[0]));
        }
    }
}