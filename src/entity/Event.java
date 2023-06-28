package entity;

import game.Game;
import generator.Generator;

public class Event extends Entity {

    public void event() {
        switch (Generator.gameGrid[Entity.playerYAxis][Entity.playerXAxis]) {
            case "amarok", "pit" -> Game.loopGame = false;
            case "maelstrom" -> moveMaelstrom(Entity.playerYAxis, Entity.playerXAxis);
            case "fountain" -> activateFountain();
            case "entrance" -> {
                if (Entity.fountain) {
                    System.out.println("The Fountain of Objects has been reactivated, and you have escaped with your life!");
                    Game.loopGame = false;
                }
            }
        }
    }

    private void activateFountain() {
        if (input.inputcheck().equals("y")) {
            Entity.fountain = true;
        }
    }

    private void moveMaelstrom(int y, int x) {
        Generator.gameGrid[y][x] = ("0");
        if (y + 1 >= Generator.mapSize - 1) {
            y = Generator.mapSize - 1;
        } else {
            y += 1;
        }
        if (x - 2 <= 0) {
            x = 0;
        } else {
            x -= 2;
        }
        displacePlayer();
        Generator.gameGrid[y][x] = ("m");
    }

    private void displacePlayer() {
        if (Entity.playerYAxis - 1 <= 0) {
            Entity.playerYAxis = 0;
        } else {
            Entity.playerYAxis -= 1;
        }
        if (Entity.playerXAxis + 2 >= Generator.mapSize - 1) {
            Entity.playerXAxis = Generator.mapSize - 1;
        } else {
            Entity.playerXAxis += 2;
        }
    }

}
