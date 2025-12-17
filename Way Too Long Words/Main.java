import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int size = s.length();

            if(size > 10){
                sb.append(s.charAt(0));
                String temp = String.valueOf(size-2);
                sb.append(temp);
                sb.append(s.charAt(size-1));
                System.out.println(sb.toString());
            }
            else{
                System.out.println(s);
            }

        }
    }
}