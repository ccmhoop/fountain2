package generator;

import java.util.Random;

public class EventGenerator extends Generator {

    public EventGenerator() {
        randomEventGenerator();
    }

    private void randomEventGenerator() {
        Random rnd = new Random();
        gameGrid[0][0] = "entrance";
        gameGrid[mapSize - 1][mapSize - 1] = "fountain";
        for (int i = 1; i <= gameMode(); i++) {
            while (true) {
                int y = rnd.nextInt(0, Generator.mapSize);
                int x = rnd.nextInt(0, Generator.mapSize);
                if (gameGrid[y][x].equals("0")) {
                    generateEvents(y, x, i);
                    break;
                }
            }
        }
    }

    private int gameMode() {
        int repeat = 0;
        switch (mapSize) {
            case 4 -> repeat = eventAmount(2, 1, 2, 3);
            case 6 -> repeat = eventAmount(2, 1, 2, 5);
            case 8 -> repeat = eventAmount(4, 2, 3, 9);
        }
        return repeat;
    }

    private int eventAmount(int pit, int maelstrom, int amarok, int repeat) {
        if (!hardMode) {
            switch (gameType) {
                case "p" -> repeat = pit;
                case "m" -> repeat = maelstrom;
                case "a" -> repeat = amarok;
            }
        }
        return repeat;
    }

    private void generateEvents(int y, int x, int increment) {
        if (hardMode) {
            generateHardMode(y, x, increment);
        } else {
            generateNormalMode(y, x);
        }
    }

    private void generateNormalMode(int y, int x) {
        switch (gameType) {
            case "p" -> gameGrid[y][x] = ("pit");
            case "m" -> gameGrid[y][x] = ("maelstrom");
            case "a" -> gameGrid[y][x] = ("amarok");
        }
    }

    private void generateHardMode(int y, int x, int increment) {
        switch (increment) {
            case 1, 4, 6, 9 -> gameGrid[y][x] = ("pit");
            case 2, 7 -> gameGrid[y][x] = ("maelstrom");
            case 3, 5, 8 -> gameGrid[y][x] = ("amarok");
        }
    }
}
