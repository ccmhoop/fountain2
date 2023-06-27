package gameLoop;

import generator.Generator;
import generator.MapGenerator;
import monster.Maelstrom;
import player.PlayerInput;

public class GameMessage {


    private static boolean fountain = false;

    public static void roomMessage(int y, int x, int size) {
        if (y == 0 && x == 0) {
            caveEntrance();
        }
        if (y == size - 1 && x == size - 1) {
            setFountain();
        }
        if (Generator.gameGrid[y][x].equals("p")) {
            System.out.println("You fell down a pit");
        }
        if (Generator.gameGrid[y][x].equals("m")) {
            Maelstrom.moveMaelstrom(y,x,size);
            System.out.println("You got blown away by a Maelstrom");
        }
        if (Generator.gameGrid[y][x].equals("a")) {
            System.out.println("The Amarok split your wig");
        }
        MapGenerator.mapPrinter(size);
    }


    private static void setFountain() {
        System.out.println("You hear water dripping in this room. The Fountain of Objects is here!\n" +
                "Do you want to activate the fountain?");
        System.out.println(fountain);
        if (PlayerInput.inputcheck().equals("y")) {
            System.out.println("You have activated the fountain");
            fountain = true;
        }
    }
    private static void caveEntrance() {
        System.out.println("You see light coming from the cavern entrance.");
        if (fountain) {
            System.out.println("The Fountain of Objects has been reactivated, and you have escaped with your life!");
        }
    }
}
