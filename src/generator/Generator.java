package generator;

public class Generator {

    public static String[][] gameGrid;

    public void runGenerator(int size){
        gameGrid = new String[size][size];
        new MapGenerator(size);
    }

}
