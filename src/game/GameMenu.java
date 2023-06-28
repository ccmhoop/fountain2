package game;

import generator.Generator;

public class GameMenu extends Game {

    public void gameMenu() {
        System.out.println(GameMessage.openingMenuMessage);
        switch (input.inputcheck()) {
            case "p" -> Generator.gameType = "p";
            case "m" -> Generator.gameType = "m";
            case "a" -> Generator.gameType = "a";
            case "h" -> Generator.hardMode = true;
        }
        GameMessage.gameSettingMessage();
        System.out.println(GameMessage.mapSizeMenuMessage);
        switch (input.inputcheck()) {
            case "small" -> Generator.mapSize = 4;
            case "medium" -> Generator.mapSize = 6;
            case "large" -> Generator.mapSize = 8;
        }
    }
}
