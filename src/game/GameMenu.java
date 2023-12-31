package game;

import enums.Color;
import generator.Generator;
import input.Input;
import java.util.Scanner;

public class GameMenu extends Game {

    private final Scanner scan = new Scanner(System.in);

    public void gameStartMenu() {
        menuGameMode();
        GameMessage.gameSettingMessage();
        menuActivateWeaponMode();
        menuMapSize();
    }

    private void menuGameMode() {
        System.out.println(Color.YELLOW.txtColor + GameMessage.GAME_FIRST_MENU_MESSAGE);
        while (Input.inputMenuMismatchCheck()) {
            switch (scan.next()) {
                case "p", "P" -> Generator.gameType = "p";
                case "m", "M" -> Generator.gameType = "m";
                case "a", "A" -> Generator.gameType = "a";
                case "h", "H" -> {
                    Generator.hardMode = true;
                    Generator.gameType = "h";
                }
                default -> Input.checkMenuInput = "mismatch";
            }
        }
    }

    private void menuMapSize() {
        System.out.println(GameMessage.GAME_SIZE_MESSAGE);
        while (Input.inputMenuMismatchCheck()) {
            switch (scan.next()) {
                case "small" -> Generator.mapSize = 4;
                case "medium" -> Generator.mapSize = 6;
                case "large" -> Generator.mapSize = 8;
                default -> Input.checkMenuInput = "mismatch";
            }
        }
    }

    private void menuActivateWeaponMode() {
        if (!Generator.gameType.equals("p")) {
            System.out.println("\nDo you want to Activate Weapon mode? y/n?\n");
            while (Input.inputMenuMismatchCheck()) {
                switch (scan.next()) {
                    case "Y","y" -> weaponMode = true;
                    case "N","n" -> Input.checkMenuInput = "n";
                    default -> Input.checkMenuInput = "mismatch";
                }
            }
        }
    }
}
