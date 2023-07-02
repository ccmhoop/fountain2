package game;

import entity.Event;
import generator.Generator;

public class Game {
    public static boolean gameActive = false;
    public static boolean weaponMode;
    public static boolean nextTurn;
    protected Event event = new Event();

    public void runGame() {
        GameMenu gameMenu = new GameMenu();
        GameLoop gameloop = new GameLoop();
        Generator generator = new Generator();
        gameMenu.gameStartMenu();
        generator.runGenerator();
        System.out.println(GameMessage.GAME_OPENING_MESSAGE);
        event.audioPlayer("src/entity/sound/BackGround.wav");
        gameActive = true;
        gameloop.gameLoop();
    }
}
