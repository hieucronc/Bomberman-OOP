package uet.oop.bomberman.sound;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundManager  {
    public static void titleScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file1 = new File(System.getProperty("user.dir") + "/res/sound/title_screen.wav");
        AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(file1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(audioStream1);
        clip1.start();
    }
    public static void bomExplosion() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file2 = new File(System.getProperty("user.dir") + "/res/sound/bomb_explosion.wav");
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
        Clip clip2 = AudioSystem.getClip();
        clip2.open(audioStream2);
        clip2.start();
    }
    public static void playerDied() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file3 = new File(System.getProperty("user.dir") + "/res/sound/player_died.wav");
        AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
        Clip clip3 = AudioSystem.getClip();
        clip3.open(audioStream3);
        clip3.start();
    }
    public static void levelComplete() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file4 = new File(System.getProperty("user.dir") + "/res/sound/level_complete.wav");
        AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(file4);
        Clip clip4 = AudioSystem.getClip();
        clip4.open(audioStream4);
        clip4.start();
    }
}
