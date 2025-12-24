import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while(testcase-- > 0){
            int k = sc.nextInt();
            int x = sc.nextInt();

            int result = (k * x)+1;
            System.out.println(result);
        }
    }
}