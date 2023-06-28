package generator;

import java.util.Random;

public class EventGenerator extends Generator {

    public EventGenerator(int size) {
        addEvents(size);
    }

    private void addEvents(int size) {
        Random rnd = new Random();
        int repeats = 0;
        gameGrid[0][0] = "e";
        gameGrid[size - 1][size - 1] = "f";
        switch (size) {
            case 4 -> repeats = 1;
            case 6 -> repeats = 2;
            case 8 -> repeats = 3;
        }
        for (int i = 0; i < repeats; i++) {
            for (int j = 0; j <= 2; j++) {
                while (true) {
                    int y = rnd.nextInt(0, size);
                    int x = rnd.nextInt(0, size);
                    if (gameGrid[y][x].equals("0")) {
                        events(y, x, j);
                        break;
                    }
                }
            }
        }
    }

    private void events(int y, int x, int inc) {
        switch (inc) {
            case 0 -> gameGrid[y][x] = ("p");
            case 1 -> gameGrid[y][x] = ("m");
            case 2 -> gameGrid[y][x] = ("a");
        }
    }
}
