package entity;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Entity {
    protected static int playerXAxis;
    protected static int playerYAxis = 0;
    private static Clip backgroundMusic;

    public static int getPlayerXAxis() {
        return playerXAxis;
    }

    public static int getPlayerYAxis() {
        return playerYAxis;
    }

    public static void setPlayerStartXAxis(int playerXAxis) {
        Entity.playerXAxis = playerXAxis;
    }

    public void audioPlayer(String filePath) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            Clip clip = AudioSystem.getClip();
            if (filePath.equals("src/entity/sound/Dead.wav") || filePath.equals("src/entity/sound/WinEffect.wav")) {
                backgroundMusic.stop();
            }
            if (filePath.equals("src/entity/sound/BackGround.wav")) {
                backgroundMusic = AudioSystem.getClip();
                backgroundMusic.open(audioStream);
                backgroundMusic.loop(3);
            } else {
                clip.open(audioStream);
                clip.start();
                do {
                    Thread.sleep(15);
                } while (clip.isRunning());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

