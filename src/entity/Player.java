package entity;

import generator.Generator;

public class Player extends Entity {

    public void playerPosition(int size) {
        String check = input.inputcheck();
        if (positionY == 0 && check.equals("w") || positionX == 0 && check.equals("a")) {
            System.out.println("you hit yo head");
        } else if (positionY == size - 1 && check.equals("s") || positionX == size - 1 && check.equals("d")) {
            System.out.println("you hit yo head");
        } else {
            playerMove(check);
        }
    }

    public void playerSense() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                setAntiSpamSense(i, j);
            }
        }
        antiSenseSpam();
    }

    private void playerMove(String input) {
        switch (input) {
            case "w" -> positionY--;
            case "s" -> positionY++;
            case "d" -> positionX++;
            case "a" -> positionX--;
        }
    }

    private void setAntiSpamSense(int forI, int forJ) {
        try {
            switch (Generator.gameGrid[positionY - 1 + forI][positionX - 1 + forJ]) {
                case "a" -> amarok = true;
                case "m" -> maelstrom = true;
                case "p" -> pit = true;
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private void antiSenseSpam() {
        if (pit) {
            System.out.println("You feel a draft. There is a pit in a nearby room.\n");
        }
        if (maelstrom) {
            System.out.println("You hear\nthe growling and groaning of a maelstrom nearby.\n");
        }
        if (amarok) {
            System.out.println("You can smell the rotten stench of an\nAmarok in a nearby room.\n");
        }
        amarok = maelstrom = pit = false;
    }
}
