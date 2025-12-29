import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size+1];
        int[] ans = new int[size+1];

        for(int i=1;i<=size;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=1;i<=size;i++){
            ans[arr[i]] = i;
        }

        for(int i=1;i<=size;i++){
            System.out.print(ans[i]+" ");
        }
    }
}