import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();
        int total = 0;

        for(int i=1;i<=w;i++){
            total = total + k*i;
        }

        System.out.println(Math.max(0 , total - n));
    }
}