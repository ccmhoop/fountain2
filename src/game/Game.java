package game;

import entity.Entity;
import entity.Event;

import generator.Generator;
import input.Input;
public class Game {

    public static boolean loopGame = true;
    Event event = new Event();
    Input input = new Input();
    Entity entity = new Entity();
    Generator generator = new Generator();

    public void runGame() {
        GameMenu gameMenu = new GameMenu();
        Gameloop gameloop = new Gameloop();
        gameMenu.gameMenu();
        generator.runGenerator();
        System.out.println(GameMessage.startGameMessage);
        gameloop.GameLoop();
    }
}
