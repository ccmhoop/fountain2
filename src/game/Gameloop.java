package game;

import entity.Player;
import generator.Generator;
import generator.MapGenerator;

public class Gameloop extends Game {


    public void GameLoop() {
        Generator generator = new Generator();
        Player player = new Player();
        GameMessage message = new GameMessage();
        int size = Integer.parseInt(input.inputcheck());
        generator.runGenerator(size);
        while (loopGame) {
            System.out.println(entity.getY() + " " + entity.getX());
            MapGenerator.mapPrinter(size);
            player.radar();
            player.playerPosition(size);
            message.gameMessage();
            event.event(size);
        }
    }

}
