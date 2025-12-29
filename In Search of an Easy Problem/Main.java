import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<size;i++){
           set.add(sc.nextInt());
        }

        if(set.contains(1)) System.out.println("HARD");
        else System.out.println("EASY");


    }
}