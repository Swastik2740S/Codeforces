import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];
        int iindex = 1;
        int jindex = 1;

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1){
                    iindex += i;
                    jindex += j;
                }
            }
        }

        int result = Math.abs(iindex-3) + Math.abs(jindex-3);
        System.out.println(result);

    
    }
}