package entity;

import generator.Generator;

public class Player extends Entity {

    public void playerPosition() {
        String check = input.inputcheck();
        if (playerYAxis == 0 && check.equals("w") || playerXAxis == 0 && check.equals("a")) {
            System.out.println("you hit yo head");
        } else if (playerYAxis == Generator.mapSize - 1 && check.equals("s") || playerXAxis == Generator.mapSize - 1 && check.equals("d")) {
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
                case "amarok" -> amarok = true;
                case "maelstrom" -> maelstrom = true;
                case "pit" -> pit = true;
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private void radarMessage() {
        if (pit) {
            System.out.println("\nYou feel a draft. There is a pit in a nearby room.\n");
        }
        if (maelstrom) {
            System.out.println("\nYou hear the growling and groaning of a maelstrom nearby.\n");
        }
        if (amarok) {
            System.out.println("\nYou can smell the rotten stench of an Amarok in a nearby room.\n");
        }
        amarok = maelstrom = pit = false;
    }
}
