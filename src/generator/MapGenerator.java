package generator;

import java.util.Random;

public class MapGenerator extends Generator {
    public MapGenerator(int size) {
        generateGame(size);
    }

    private void generateGame(int size) {
        for (int rows = 0; rows < (size); rows++) {
            for (int column = 0; column < size; column++) {
                gameGrid[rows][column] = "0";
            }
        }
        gameGrid[0][0] = "e";
        gameGrid[size - 1][size - 1] = "f";
        addEvents(size);
    }

    private void addEvents(int size) {
        Random rnd = new Random();
        int repeats = 0;
        switch (size) {
            case 4 -> repeats = 1;
            case 6 -> repeats = 2;
            case 8 -> repeats = 3;
        }
        for (int i = 0; i < repeats; i++) {
            for (int j = 0; j <= 2; j++) {
                while (true) {
                    int y = rnd.nextInt(0, size - 1);
                    int x = rnd.nextInt(0, size - 1);
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

    public static void mapPrinter(int size) {
        int printRoom = 0;
        for (int rows = 0; rows < size; rows++) {
            for (int columns = 0; columns < size; columns++) {
                printRoom++;
                System.out.print(gameGrid[rows][columns] + " ");
                if (printRoom == (size * size * size)) {
                    System.out.println();
                    printRoom = 0;
                }
            }
            System.out.println("row " + rows);
        }
    }
}
