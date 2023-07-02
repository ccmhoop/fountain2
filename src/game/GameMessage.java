package game;

import entity.Entity;
import entity.Event;
import entity.Player;
import enums.Color;
import generator.Generator;

public class GameMessage extends Game {

    protected static final String GAME_OPENING_MESSAGE = """
                        
            You enter the Cavern of Objects, a maze of rooms filled with dangerous and pits in
            search of the Fountain of Objects. Light is visible only in the entrance, and
            no other light is seen anywhere in the caverns. You must navigate the Caverns
            with your other senses. Find the Fountain of Objects, activate it, and return
            to the entrance.
                        
            Type : menu to see all Commands
            """;

    protected static final String GAME_FIRST_MENU_MESSAGE = """
                        
            Fountain of Objects

            What Game mode would you like to play?
            Type p,m,a or h

            p = Pit Challenge
            m = Maelstrom Challenge
            a = Amarok Challenge
            h = Hard mode
            """;

    protected static final String GAME_SIZE_MESSAGE = """

            Enter cave size
            small,medium,large
            """;

    public static final String MAELSTROM_HIT = """
                        
            Within the depths of the dark cave, a swirling maelstrom of chaotic energy threatened to consume everything
            in its path, but with unwavering determination, you released a single arrow that cut through the tempest,
            dispersing its destructive power and bringing an end to the tumultuous vortex.
            """;
    public static final String AMAROK_HIT = """
                        
            In the pitch-black depths of the cave, guided solely by the putrid stench of the Amarok, you
            unleashed an arrow.As your arrow sliced through the veil of darkness, it found its mark, striking the
            Amarok with deadly precision a satisfying thud can be heard, momentarily quelling the beast's ferocity.
            """;
    public static final String FOUNTAIN_ACTIVATED = "You hear the rushing waters from the Fountain of Objects. It has been reactivated!";

    public static void movementMessages(String input) {
        if (Entity.getPlayerYAxis() == 0 && input.equals("w") || Entity.getPlayerXAxis() == 0 && input.equals("a")) {
            System.out.println(Color.RED.txtColor + "you hit a wall\n");
            Player.movePlayer = false;
        } else if (Entity.getPlayerYAxis() == Generator.mapSize - 1 && input.equals("s") || Entity.getPlayerXAxis() == Generator.mapSize - 1 && input.equals("d")) {
            System.out.println(Color.RED.txtColor + "you hit a wall\n");
            Player.movePlayer = false;
        } else {
            switch (input) {
                case "w" -> System.out.println(Color.BLUE.txtColor + "Moving North");
                case "s" -> System.out.println(Color.BLUE.txtColor + "Moving South");
                case "d" -> System.out.println(Color.BLUE.txtColor + "Moving East");
                case "a" -> System.out.println(Color.BLUE.txtColor + "Moving West");
                default -> {
                    return;
                }
            }
            if (Player.movePlayer) {
                nextTurn = true;
            }
        }
    }

    public static void arrowMessage(int arrow) {
        switch (arrow) {
            case 2, 3, 4, 5 -> System.out.println(Color.YELLOW.txtColor + arrow + " Arrows Left");
            case 1 -> System.out.println(Color.YELLOW.txtColor + arrow + " Arrow Left");
            case 0 -> System.out.println(Color.YELLOW.txtColor + "Out of Arrows");
        }
    }

    private void fountainMessage() {
        if (Event.fountain) {
            if (Generator.getGameGrid().equals("fountain")) {
                System.out.println(Color.YELLOW.txtColor + """
                                                
                        The fountain is flowing, its radiant waters illuminating the surrounding gloom with enchanting
                        beauty and a soothing melody that echoes through the depths.""");
            }
        } else {
            System.out.println(Color.GREEN.txtColor + """
                                
                    You hear water dripping in this room. The Fountain of Objects is here!
                    Do you want to activate the fountain?
                                                        
                    Type : y to activate or move on""");
        }
    }

    public static void gameSettingMessage() {
        System.out.println(Color.YELLOW.txtColor + "\nGame Setting");
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
            case "h" -> System.out.println("You have chosen Hard mode. All enemy types and events have been spawned.");
        }
        if (gameActive) {
            System.out.println("\nMove Commands\nw = North, s = South, a = West, d = East");
            if (weaponMode) {
                System.out.println("""
                                            
                        Shoot Commands Type:arrow to see remaining arrows
                        s.n, s.ne, s.e, s.se, s.s, s.sw, s.w, s.nw""");
            }
        }
    }

    public void runningGameMessages() {
        if (gameActive) {
            switch (Generator.getGameGrid()) {
                case "amarok" -> System.out.println(Color.RED.txtColor + """
                                                
                        In the suffocating darkness of the cave, the Amarok, emanating a putrid stench,
                        unleashed a relentless assault upon you, tearing through flesh and bone,
                        your life extinguished amidst the noxious fumes and haunting echoes of the beast's triumph
                        """);
                case "maelstrom" -> System.out.println(Color.CYAN.txtColor + """
                                                
                        In the treacherous darkness of the cave,the you found yourself at the mercy
                        of a swirling maelstrom, which seized hold of you with an unyielding grip. With a mighty force,
                        the maelstrom flung you through the air,hurtling you into an unknown location
                        within the depths of the cavern, leaving you disoriented and at the mercy of the unknown.
                        """);
                case "pit" -> System.out.println(Color.RED.txtColor + """
                                                
                        In the enveloping darkness of the cave, you stumbled, lost your footing,
                        and plummeted into the unfathomable depths of a treacherous pit,
                        your terrified screams fading into the abyss below.
                        """);
                case "fountain" -> fountainMessage();
                case "entrance" -> System.out.println(Color.YELLOW.txtColor +
                        "\nYou see light coming from the cavern entrance.");
            }
        }
    }
}
