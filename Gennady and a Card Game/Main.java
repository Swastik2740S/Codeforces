import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Card on the table
        String table = sc.next();
        char tableRank = table.charAt(0);
        char tableSuit = table.charAt(1);

        boolean canPlay = false;

        // Five cards in hand
        for (int i = 0; i < 5; i++) {
            String card = sc.next();
            char rank = card.charAt(0);
            char suit = card.charAt(1);

            if (rank == tableRank || suit == tableSuit) {
                canPlay = true;
                break;
            }
        }

        System.out.println(canPlay ? "YES" : "NO");
    }
}
