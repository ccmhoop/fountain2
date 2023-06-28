package entity;

import generator.Generator;

public class Player extends Entity {

    public void playerPosition(int size) {
        String check = input.inputcheck();
        if (playerYAxis == 0 && check.equals("w") || playerXAxis == 0 && check.equals("a")) {
            System.out.println("you hit yo head");
        } else if (playerYAxis == size - 1 && check.equals("s") || playerXAxis == size - 1 && check.equals("d")) {
            System.out.println("you hit yo head");
        } else {
            playerMove(check);
        }
    }

    public void radar() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                radarSpamControl(i, j);
            }
        }
        radarMessage();
    }

    private void playerMove(String input) {
        switch (input) {
            case "w" -> playerYAxis--;
            case "s" -> playerYAxis++;
            case "d" -> playerXAxis++;
            case "a" -> playerXAxis--;
        }
    }

    private void radarSpamControl(int forI, int forJ) {
        try {
            switch (Generator.gameGrid[playerYAxis - 1 + forI][playerXAxis - 1 + forJ]) {
                case "a" -> amarok = true;
                case "m" -> maelstrom = true;
                case "p" -> pit = true;
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private void radarMessage() {
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
