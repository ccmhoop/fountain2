package entity;


import input.Input;

public class Entity {
    protected static int playerXAxis = 0;
    protected static int playerYAxis = 0;
    protected static boolean fountain = false;
    protected Input input = new Input();
    protected boolean amarok;
    protected boolean maelstrom;
    protected boolean pit;

    public int getPlayerXAxis() {
        return playerXAxis;
    }

    public int getPlayerYAxis() {
        return playerYAxis;
    }

}
