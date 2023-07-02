package entity;

import enums.Color;
import game.Game;
import generator.Generator;

public class Event extends Entity {

    public static boolean fountain = false;

    //checks player position on the map activate events
    public void event() {
        switch (Generator.getGameGrid()) {
            case "amarok", "pit" -> {
                System.out.println("You Died");
                audioPlayer("src/entity/sound/Dead.wav");
                Game.gameActive = false;
            }
            case "maelstrom" -> moveMaelstrom(Entity.playerYAxis, Entity.playerXAxis);
            case "entrance" -> {
                if (fountain) {
                    System.out.println(Color.YELLOW.txtColor + "The Fountain of Objects has been reactivated, and you have escaped with your life!");
                    audioPlayer("src/entity/sound/WinEffect.wav");
                    Game.gameActive = false;
                }
            }
        }
    }

    //moves the maelstrom around when player moves into its room according to map size
    private void moveMaelstrom(int y, int x) {
        Generator.gameGrid[y][x] = ("0");
        if (y + 1 >= Generator.mapSize - 1) {
            y = Generator.mapSize - 1;
        } else {
            y++;
        }
        if (x - 2 <= 0) {
            x = 0;
        } else {
            x -= 2;
        }
        displacePlayer();
        //When the maelstrom is moved it won't overwrite other events
        switch (Generator.gameGrid[y][x]) {
            case "amarok", "pit" -> x++;
            case "fountain" -> y--;
        }
        switch (Generator.gameGrid[y][x]) {
            case "amarok", "pit" -> y--;
            case "fountain" -> x++;
        }
        Generator.gameGrid[y][x] = ("maelstrom");
    }

    //moves the player when player moves into the maelstrom room according to map size
    private void displacePlayer() {
        if (Entity.playerYAxis - 1 <= 0) {
            Entity.playerYAxis = 0;
        } else {
            Entity.playerYAxis--;
        }
        if (Entity.playerXAxis + 2 >= Generator.mapSize - 1) {
            Entity.playerXAxis = Generator.mapSize - 1;
        } else {
            Entity.playerXAxis += 2;
        }
    }
}
