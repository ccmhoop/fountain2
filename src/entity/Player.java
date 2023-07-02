package entity;

import enums.Color;
import game.Game;
import game.GameMessage;
import generator.Generator;

import java.util.Scanner;

public class Player extends Entity {
    public static boolean movePlayer;
    private boolean amarok;
    private boolean maelstrom;
    private boolean pit;
    private int arrow = 5;
    private final Scanner scanner = new Scanner(System.in);

    //checks for playerInput and executes actions according to events
    public void playerInput() {
        playerRadar();
        Game.nextTurn = false;
        while (!Game.nextTurn) {
            movePlayer = true;
            String input = scanner.next();
            GameMessage.movementMessages(input);
            playerRequestMenu(input);
            playerInteractFountain(input);
            playerActions(input);
        }
    }

    //method changes message feedback when the player is at the fountain
    private void playerInteractFountain(String input) {
        if (Generator.getGameGrid().equals("fountain")) {
            if (input.equalsIgnoreCase("y") && !Event.fountain) {
                Event.fountain = true;
                System.out.println(Color.YELLOW.txtColor + GameMessage.FOUNTAIN_ACTIVATED);
            }
            if (!Event.fountain && (input.equals("w") || input.equals("a") || input.equals("d"))) {
                if (movePlayer) {
                    System.out.println(Color.YELLOW.txtColor + "\nYou move on without activating the fountain");
                }
            }
        }
    }

    private void playerRequestMenu(String input) {
        if (input.equals("menu")) {
            GameMessage.gameSettingMessage();
        }
        if (Game.weaponMode && input.equals("arrow")) {
            GameMessage.arrowMessage(arrow);
        }
    }

    //---------------player actions uses shoot(); and shoot uses enemyHit()---------------------------
    private void playerActions(String input) {
        if (Game.weaponMode) {
            playerShoot(Entity.getPlayerYAxis(), Entity.getPlayerXAxis(), input);
        }
        if (Player.movePlayer) {
            switch (input) {
                case "w" -> playerYAxis--;
                case "s" -> playerYAxis++;
                case "d" -> playerXAxis++;
                case "a" -> playerXAxis--;
            }
        }
    }

    private void playerShoot(int playerY, int playerX, String input) {
        if (arrow > 0) {
            switch (input) {
                case "s.n" -> playerEnemyHitCheck(--playerY, playerX);
                case "s.ne" -> playerEnemyHitCheck(--playerY, ++playerX);
                case "s.e" -> playerEnemyHitCheck(playerY, ++playerX);
                case "s.se" -> playerEnemyHitCheck(++playerY, ++playerX);
                case "s.s" -> playerEnemyHitCheck(++playerY, playerX);
                case "s.sw" -> playerEnemyHitCheck(++playerY, --playerX);
                case "s.w" -> playerEnemyHitCheck(playerY, --playerX);
                case "s.nw" -> playerEnemyHitCheck(--playerY, --playerX);
                default -> {
                    return;
                }
            }
            arrow--;
            audioPlayer("src/entity/sound/Bow.wav");
            GameMessage.arrowMessage(arrow);
        }
    }

    private void playerEnemyHitCheck(int playerY, int playerX) {
        //Main If statement fixes index out of bounds
        if (playerY >= 0 && playerY < Generator.mapSize && playerX >= 0 && playerX < Generator.mapSize) {
            if (Generator.gameGrid[playerY][playerX].equals("maelstrom")) {
                Generator.gameGrid[playerY][playerX] = "0";
                System.out.println(Color.YELLOW.txtColor + GameMessage.MAELSTROM_HIT);
            }
            if (Generator.gameGrid[playerY][playerX].equals("amarok")) {
                Generator.gameGrid[playerY][playerX] = "0";
                System.out.println(Color.YELLOW.txtColor + GameMessage.AMAROK_HIT);
            }
        }
    }

    private void playerRadar() {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                radarSpamControl(i, j);
            }
        }
        amarok = maelstrom = pit = false;
    }

    private void radarSpamControl(int loopI, int loopJ) {
        try {
            if (Generator.gameGrid[playerYAxis + loopI][playerXAxis + loopJ].equals("amarok") && !amarok) {
                System.out.println(Color.RED.txtColor + "\nYou can smell the rotten stench of an Amarok in a nearby room.\n");
                amarok = true;
            }
            if (Generator.gameGrid[playerYAxis + loopI][playerXAxis + loopJ].equals("maelstrom") && !maelstrom) {
                System.out.println(Color.CYAN.txtColor + "\nYou hear the growling and groaning of a maelstrom nearby.\n");
                maelstrom = true;
            }
            if (Generator.gameGrid[playerYAxis + loopI][playerXAxis + loopJ].equals("pit") && !pit) {
                System.out.println(Color.PURPLE.txtColor + "\nYou feel a draft. There is a pit in a nearby room.\n");
                pit = true;
            }
        } catch (IndexOutOfBoundsException ignored) {
        }
    }
}
