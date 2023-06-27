package player;

import monster.Monster;

public class PlayerAbilities extends Player{

    private static final Monster monster = new Monster();

    public void playerSense() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                senseCheck(i, j);
            }
        }
        antiSenseSpam();
    }

    private void senseCheck(int forI, int forJ) {
        monster.setSenseMonster(getY(),getX(),forI,forJ,false);
        antiSenseSpam();
    }

    private void antiSenseSpam(){
        if (Monster.isPit()) {
            System.out.println("You feel a draft. There is a pit in a nearby room.\n");
        }
        if(Monster.isMaelstorm()) {
            System.out.println("You hear\nthe growling and groaning of a maelstrom nearby.\n");
        }
        if(Monster.isAmarok()){
            System.out.println("You can smell the rotten stench of an\nAmarok in a nearby room.\n");
        }
        monster.setSenseMonster(0,0,0,0,true);
    }

}
