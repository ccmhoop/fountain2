package monster;

import generator.Generator;
import player.Player;

public class Maelstrom extends Monster {



    public static void moveMaelstrom(int y, int x, int size) {
        movePlayer(y,x,size);
        Generator.gameGrid[y][x] = ("0");
        if (y + 1 >= size - 1) {
            y = size - 1;
        } else {
            y += 1;
        }
        if (x - 2 <= 0) {
            x = 0;
        } else {
            x -= 2;
        }
        Generator.gameGrid[y][x] = ("m");
    }

    private static void movePlayer(int y, int x, int size) {
        if (y - 1 <= 0) {
            y = 0;
        } else {
            y -= 1;
        }
        if (x + 2 >= size - 1) {
            x = size - 1;
        } else {
            x += 2;
        }
        Player.setYX(y, x);
    }
}
