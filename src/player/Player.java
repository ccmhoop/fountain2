package player;

public class Player {

    private static int x = 0;
    private static int y = 0;



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void setYX(int y, int x) {
        Player.x = x;
        Player.y = y;
    }



}
