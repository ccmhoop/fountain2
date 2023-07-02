package generator;

import entity.Entity;
import java.util.Random;

public class EventGenerator extends Generator {

    //-------------------------Method places events in random places ---------------------------------------------------
    public static void randomEventGenerator() {
        Random rnd = new Random();
        Entity.setPlayerStartXAxis(rnd.nextInt(0, Generator.mapSize));
        //places entrance
        gameGrid[0][Entity.getPlayerXAxis()] = "entrance";
        //places fountain
        gameGrid[mapSize - 1][rnd.nextInt(0, Generator.mapSize)] = "fountain";
        //places event according to game mode
        for (int i = 1; i <= eventLoopLimiter(); i++) {
            while (true) {
                int mapYAxis = rnd.nextInt(0, Generator.mapSize);
                int mapXAxis = rnd.nextInt(0, Generator.mapSize);
                if (gameGrid[mapYAxis][mapXAxis].equals("0")) {
                    addEventOnMap(mapYAxis, mapXAxis, i);
                    break;
                }
            }
        }
    }

    //-------------------------Methods to spawn the right amounts of events---------------------------------------------

    private static int eventLoopLimiter() {
        return switch (mapSize) {
            case 4 -> gameModeSpawnLimiter(1, 1, 1, 3);
            case 6 -> gameModeSpawnLimiter(2, 1, 2, 5);
            case 8 -> gameModeSpawnLimiter(4, 2, 3, 9);
            default -> throw new IllegalArgumentException();
        };
    }

    private static int gameModeSpawnLimiter(int pit, int maelstrom, int amarok, int hardmode) {
        //Hard mode skips Switch(gametype). and returns default parameter value which is related to hardmode and mapsize.
        if (!hardMode) {
            return switch (gameType) {
                case "p" -> pit;
                case "m" -> maelstrom;
                case "a" -> amarok;
                default -> throw new IllegalArgumentException();
            };
        }
        return hardmode;
    }

    //--------------------Methods to spawn the right event for the requested game mode----------------------------------
    //y = y axis x = x axis
    private static void addEventOnMap(int y, int x, int increment) {
        if (hardMode) {
            hardModeEvents(y, x, increment);
        } else {
            normalModeEvents(y, x);
        }
    }

    private static void normalModeEvents(int y, int x) {
        switch (gameType) {
            case "p" -> gameGrid[y][x] = "pit";
            case "m" -> gameGrid[y][x] = "maelstrom";
            case "a" -> gameGrid[y][x] = "amarok";
        }
    }

    private static void hardModeEvents(int y, int x, int increment) {
        switch (increment) {
            case 1, 4, 6, 9 -> gameGrid[y][x] = "pit";
            case 2, 7 -> gameGrid[y][x] = "maelstrom";
            case 3, 5, 8 -> gameGrid[y][x] = "amarok";
        }
    }
}
