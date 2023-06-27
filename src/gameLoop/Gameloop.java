package gameLoop;

import generator.Generator;
import player.Player;
import player.PlayerAbilities;
import player.PlayerInput;
import player.PlayerMovement;

public class Gameloop {


    public void GameLoop() {
        Generator generator = new Generator();
        Player player = new Player();
        PlayerMovement playerMovement = new PlayerMovement();
        PlayerAbilities playerAbilities = new PlayerAbilities();
        int size = Integer.parseInt(PlayerInput.inputcheck());
        generator.runGenerator(size);
        while (true) {
            playerAbilities.playerSense();
            GameMessage.roomMessage(player.getY(), player.getX(), size);
            playerMovement.playerPosition(size, PlayerInput.inputcheck(),player.getY(),player.getX());
        }
    }

}
