import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int result = 0;
        while (input-- >0) {
            int[] arr = new int[3];
            for(int i=0;i<3;i++){
                arr[i] = sc.nextInt();
            }

            int count = 0;
            for(int num : arr){
                if(num ==1) count++;
            }

            if(count >= 2) result++;
        }

        System.out.println(result);


    }
}
