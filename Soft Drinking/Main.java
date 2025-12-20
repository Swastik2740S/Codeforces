import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k,l,c,d,p,nl,np = 0;

        n = sc.nextInt();
        k = sc.nextInt();
        l = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        p = sc.nextInt();
        nl = sc.nextInt();
        np = sc.nextInt();

        int total = k*l;
        
        int toast = total/nl;
       
        int limes = c*d;
       
        int salt = p/np;
    

        int min1 = Math.min(toast , limes);
      
        int min2 = Math.min(salt, min1);
   

        int finalans = min2 / n;
        System.out.println(finalans);

    }
}