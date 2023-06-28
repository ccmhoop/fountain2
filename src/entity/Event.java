package entity;

import game.Game;
import generator.Generator;

public class Event extends Entity {

    public void event(int size) {
        switch (Generator.gameGrid[Entity.playerYAxis][Entity.playerXAxis]) {
            case "a", "p" -> Game.loopGame = false;
            case "m" -> moveMaelstrom(Entity.playerYAxis, Entity.playerXAxis, size);
            case "f" -> activateFountain();
            case "e" -> {
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

    private void moveMaelstrom(int y, int x, int size) {
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
        displacePlayer(size);
        Generator.gameGrid[y][x] = ("m");
    }

    private void displacePlayer(int size) {
        if (Entity.playerYAxis - 1 <= 0) {
            Entity.playerYAxis = 0;
        } else {
            Entity.playerYAxis -= 1;
        }
        if (Entity.playerXAxis + 2 >= size - 1) {
            Entity.playerXAxis = size - 1;
        } else {
            Entity.playerXAxis += 2;
        }
    }

}
