import javax.sound.sampled.*;
import java.io.File;
import java.util.List;

public class AudioPlayer {
    public List<File> songFiles;
    private Clip clip;
    private float currentVolume;

    public AudioPlayer(List<File> songFiles) throws LineUnavailableException {
        this.songFiles = songFiles;
        this.clip = AudioSystem.getClip();
        this.currentVolume = 0.0f;
    }

    public Clip getClip() {
        return clip;
    }

    public void openSong(File file) {
        try {
            if (clip.isOpen()) {
                clip.close();
            }
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
            clip.open(audioInput);
            setVolume(currentVolume);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVolume(float volume) {
        try {
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(volume);
            this.currentVolume = volume;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float getCurrentVolume() {
        return currentVolume;
    }
}