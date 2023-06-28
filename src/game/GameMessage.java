package game;

import generator.Generator;

public class GameMessage extends Game {

    public void gameMessage() {
        messages();
    }

    private void messages() {
       if (loopGame) {
           switch (Generator.gameGrid[entity.getY()][entity.getX()]) {
               case "a" -> System.out.println("The Amarok split your wig");
               case "m" -> System.out.println("You got blown away by a Maelstrom");
               case "p" -> System.out.println("You fell down a pit");
               case "f" -> System.out.println("You hear water dripping in this room. The Fountain of Objects is here!\n" + "Do you want to activate the fountain?");
               case "e" -> System.out.println("You see light coming from the cavern entrance.");
               }
           }
       }
}
