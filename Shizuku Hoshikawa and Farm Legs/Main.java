import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- >0){
            int input = sc.nextInt();

            if(input%2!=0){
                System.out.println(0);
            }
            else{
                System.out.println((input/4)+1);
            }
        }
    }
}