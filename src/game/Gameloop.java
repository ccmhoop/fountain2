package game;

import entity.Player;

public class Gameloop extends Game {

    public void GameLoop() {
        Player player = new Player();
        GameMessage message = new GameMessage();
        while (loopGame) {
//            System.out.println(entity.getPlayerYAxis() + " " + entity.getPlayerXAxis());
//            MapGenerator.mapPrinter(Generator.mapSize);
            player.radar();
            player.playerPosition();
            message.triggeredEventMessages();
            event.event();
        }
    }

}
