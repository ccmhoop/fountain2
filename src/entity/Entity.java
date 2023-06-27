package entity;


import input.Input;

public class Entity {
    protected Input input = new Input();
    protected static int positionX = 0;
    protected static int positionY = 0;
    protected boolean amarok;
    protected boolean maelstrom;
    protected boolean pit;

    public int getX() {
        return positionX;
    }

    public int getY() {
        return positionY;
    }

}
