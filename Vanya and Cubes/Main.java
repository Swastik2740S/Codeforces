import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int height = 0;
        int used = 0;

        while (true) {
            height++;
            int cubesForLevel = height * (height + 1) / 2;
            used += cubesForLevel;

            if (used > n) {
                System.out.println(height - 1);
                break;
            }
        }
    }
}
