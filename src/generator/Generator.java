package generator;

public class Generator {

    public static int mapSize;

    public static boolean hardMode=false;

    public static String gameType;

    public static String[][] gameGrid;

    public void runGenerator() {
        gameGrid = new String[mapSize][mapSize];
        new MapGenerator();
        new EventGenerator();
    }

}
