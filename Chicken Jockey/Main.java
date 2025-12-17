import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        while(test_case-- > 0){

            int size = sc.nextInt();
            int[] h = new int[size];

            for(int i=0;i<size;i++){
                h[i] = sc.nextInt();
            }

            long ans = 0;

            for(int i=0;i<size;i++){
                ans = Math.max(ans,h[i] - i);
            }

            System.out.println(ans);
        }
    }
}