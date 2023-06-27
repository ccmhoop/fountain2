package player;
import java.util.Scanner;

public class PlayerInput {

    public static String inputcheck() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.next();
            if (input.matches("[a-zA-Z]+")) {
                break;
            } else if (input.matches("[0-9]+")) {
                input.trim();
                break;
            }
        }
        return input;
    }

}
