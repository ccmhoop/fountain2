package game;

import generator.Generator;

public class GameMessage extends Game {

    protected static final String startGameMessage = """
                        
            You enter the Cavern of Objects, a maze of rooms filled with dangerous pits in
            search of the Fountain of Objects. Light is visible only in the entrance, and
            no other light is seen anywhere in the caverns. You must navigate the Caverns
            with your other senses. Find the Fountain of Objects, activate it, and return
            to the entrance.""";

    protected static final String openingMenuMessage = """
                        
            Fountain of Objects

            What Game mode would you like to play?
            Type p,m,a or h

            p = Pit Challenge
            m = Maelstrom Challenge
            a = Amarok Challenge
            h = Hardmode
            """;

    protected static final String mapSizeMenuMessage = """

            Enter cave size
            small,medium,large
            """;

    public void triggeredEventMessages() {
        runningGameMessages();
    }

    protected static void gameSettingMessage() {
        switch (Generator.gameType) {
            case "p" -> System.out.println("""
                                                
                    Look out for pits. You will feel a breeze if a pit is in an adjacent room. If
                    you enter a room with a pit, you will die.""");
            case "m" -> System.out.println("""

                    Maelstroms are violent forces of sentient wind. Entering a room
                    with one could transport you to any other location in the caverns. You will be
                    able to hear their growling and groaning in nearby rooms.""");
            case "a" -> System.out.println("""

                    Amaroks roam the caverns. Encountering one is certain death, but you can smell
                    their rotten stench in nearby rooms.""");
        }
    }

    private void runningGameMessages() {
        if (loopGame) {
            switch (Generator.gameGrid[entity.getPlayerYAxis()][entity.getPlayerXAxis()]) {
                case "amarok" -> System.out.println("\nThe Amarok split your wig");
                case "maelstrom" -> System.out.println("\nYou got blown away by a Maelstrom");
                case "pit" -> System.out.println("\nYou fell down a pit");
                case "fountain" -> System.out.println("""
                                                        
                        You hear water dripping in this room. The Fountain of Objects is here!
                        Do you want to activate the fountain?""");
                case "entrance" -> System.out.println("\nYou see light coming from the cavern entrance.");
            }
        }
    }
}
