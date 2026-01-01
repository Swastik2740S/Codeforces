import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int currentPassengers = 0;
        int maxPassengers = 0;

        for (int i = 0; i < n; i++) {
            int exit = sc.nextInt();
            int enter = sc.nextInt();

            currentPassengers -= exit;

            currentPassengers += enter;

            maxPassengers = Math.max(maxPassengers, currentPassengers);
        }

        System.out.println(maxPassengers);

    }
}
