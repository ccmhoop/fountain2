package generator;

public class MapGenerator extends Generator {
    public MapGenerator() {
        generateGame();
    }

    private void generateGame() {
        for (int rows = 0; rows < Generator.mapSize; rows++) {
            for (int column = 0; column < Generator.mapSize; column++) {
                gameGrid[rows][column] = "0";
            }
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
        System.out.println();
    }
}
