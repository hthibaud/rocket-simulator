package utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.*;

public class SoundManager {

    private static Clip backgroundClip;

    public static void playSound(String resourcePath) {
        try {
            InputStream audioSrc = SoundManager.class.getResourceAsStream(resourcePath);
            if (audioSrc == null) {
                System.err.println("Can't find audio file: " + resourcePath);
                return;
            }
            
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            
        } catch (Exception e) {
            System.err.println("Audio error: " + e.getMessage());
        }
    }

    public static void startBackgroundMusic(String resourcePath) {
        new Thread(() -> {
            try {
                InputStream audioSrc = SoundManager.class.getResourceAsStream(resourcePath);
                InputStream bufferedIn = new BufferedInputStream(audioSrc);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
                
                backgroundClip = AudioSystem.getClip();
                backgroundClip.open(audioStream);
                
                backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
                backgroundClip.start();
                
            } catch (Exception e) {
                System.err.println("Music error: " + e.getMessage());
            }
        }).start();
    }

    public static void stopMusic() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            backgroundClip.stop();
        }
    }
}