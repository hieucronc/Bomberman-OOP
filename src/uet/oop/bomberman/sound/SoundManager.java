package uet.oop.bomberman.sound;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundManager  {
    public static void titleScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file1 = new File(System.getProperty("user.dir") + "/res/sound/title_screen.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file1);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
    public static void bomExplosion() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file2 = new File(System.getProperty("user.dir") + "/res/sound/bomb_explosion.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file2);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
    public static void playerDied() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file3 = new File(System.getProperty("user.dir") + "/res/sound/player_died.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file3);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
    public static void levelComplete() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file4 = new File(System.getProperty("user.dir") + "/res/sound/level_complete.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file4);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
}
