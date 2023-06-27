package monster;

import generator.Generator;
import player.Player;

public class Monster {

    private static boolean amarok;
    private static boolean maelstorm;
    private static boolean pit;

    public static boolean isAmarok() {
        return amarok;
    }

    public static boolean isMaelstorm() {
        return maelstorm;
    }

    public static boolean isPit() {
        return pit;
    }

    public void setSenseMonster(int y,int x,int i, int j,boolean reset){
        try {
        switch (Generator.gameGrid[y - 1 + i][x - 1 + j]){
            case "a" -> amarok=true;
            case "m" -> maelstorm=true;
            case "p" -> pit=true;
        }
    } catch (IndexOutOfBoundsException ignored) {
    }
        if (reset){
            amarok = maelstorm = pit = false;
        }
    }

}
