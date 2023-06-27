package entity;

import generator.Generator;

public class Monster extends Entity {


    public void moveMaelstrom(int y, int x, int size) {
        movePlayer(size);
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

    private void movePlayer(int size) {
        if (Entity.positionY - 1 <= 0) {
            Entity.positionY = 0;
        } else {
            Entity.positionY -= 2;
        }
        if (Entity.positionX + 2 >= size - 1) {
            Entity.positionX = size - 1;
        } else {
            Entity.positionX += 2;
        }
    }

}
