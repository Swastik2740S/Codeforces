import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        while(input-- > 0){
            int n = sc.nextInt();
            List<Integer> result = new ArrayList<>();
            int place = 1;

            while(n > 0){
                int lastdigit = n%10;
                if(lastdigit > 0){
                    result.add(lastdigit*place);
                }
                place = place*10;
                n = n/10;
            }

            System.out.println(result.size());
            for(int x :result){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}