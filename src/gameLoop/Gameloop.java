package gameLoop;

import entity.Entity;
import entity.Monster;
import entity.Player;
import generator.Generator;
import input.Input;

public class Gameloop {
    Monster monster = new Monster();
    Input input = new Input();
    Entity entity = new Entity();

    public void GameLoop() {
        Generator generator = new Generator();
        Player player = new Player();
        GameMessage message = new GameMessage();
        int size = Integer.parseInt(input.inputcheck());
        generator.runGenerator(size);
        while (true) {
            message.gameMessage(size);
            player.playerSense();
            player.playerPosition(size);
        }
    }

}
