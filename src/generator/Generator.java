package generator;

import entity.Player;

public class Generator {

    public static int mapSize;
    public static boolean hardMode = false;
    public static String gameType;
    public static String[][] gameGrid;

    public static String getGameGrid() {
        return gameGrid[Player.getPlayerYAxis()][Player.getPlayerXAxis()];
    }

    public void runGenerator() {
        gameGrid = new String[mapSize][mapSize];
        MapGenerator.generateGame();
        EventGenerator.randomEventGenerator();
    }
}
