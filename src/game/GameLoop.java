package game;

import entity.Player;

public class GameLoop extends Game {

    public void gameLoop() {
        Player player = new Player();
        GameMessage message = new GameMessage();
        while (gameActive) {
            player.playerInput();
            message.runningGameMessages();
            event.event();
        }
    }
}
