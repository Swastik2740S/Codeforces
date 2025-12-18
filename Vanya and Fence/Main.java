import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int height = sc.nextInt();
        int[] arr = new int[input];

        for(int i=0;i<input;i++){
            arr[i] = sc.nextInt();
        }

        int count = 0;

        for(int i=0;i<input;i++){
            if (arr[i] > height) {
                count+=2;
            }
            else{
                count++;
            }
        }

        System.out.println(count);
    }
}