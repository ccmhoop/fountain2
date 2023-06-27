package player;

public class PlayerMovement extends Player {


    private void playerMove(String input,int y,int x) {
        switch (input) {
            case "w" -> y--;
            case "s" -> y++;
            case "d" -> x++;
            case "a" -> x--;
        }
        setYX(y,x);
    }

    public void playerPosition(int size, String input,int y,int x) {
        if (y == 0 && input.equals("w") || x == 0 && input.equals("a")) {
            System.out.println("you hit yo head");
        } else if (y == size - 1 && input.equals("s") || x == size - 1 && input.equals("d")) {
            System.out.println("you hit yo head");
        } else {
            playerMove(input,y,x);
        }
    }
}
