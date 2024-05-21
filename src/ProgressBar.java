import javax.swing.*;
import java.awt.*;

public class ProgressBar {
    private JProgressBar progressBar;
    private AudioPlayer audioPlayer;
    

    public ProgressBar(JProgressBar progressBar, AudioPlayer audioPlayer) {
        this.progressBar = progressBar;
        this.audioPlayer = audioPlayer;
    }

    public void setupProgressBar() {
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBounds(20, 160, 400, 20);
        progressBar.setForeground(new Color(15, 20, 28));
        progressBar.setFont(new Font("Arial", Font.BOLD, 15));
    }

    public void updateProgressBar() {
        if (audioPlayer.getClip().isRunning()) {
            long currentPosition = audioPlayer.getClip().getMicrosecondPosition();
            long totalDuration = audioPlayer.getClip().getMicrosecondLength();
            double progress = (double) currentPosition / totalDuration;
            int value = (int) (progress * 100);
            progressBar.setValue(value);
        }
    }

    public void resetProgressBar() {
        progressBar.setValue(0);
    }
}
