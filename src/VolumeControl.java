import javax.swing.*;
import java.awt.*;

public class VolumeControl {
    private JSlider volumeSlider;

    public VolumeControl(AudioPlayer audioPlayer) {
        volumeSlider = new JSlider(JSlider.HORIZONTAL, -50, 2, 0);
        volumeSlider.setLayout(null);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintTrack(true);
        volumeSlider.setMajorTickSpacing(20);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setBounds(20, 200, 200, 50);
        volumeSlider.setBackground(new Color(15, 20, 28));
        
        JLabel volumeLabel = new JLabel("VOLUME");
        volumeLabel.setFont(new Font("Arial", Font.BOLD, 12));
        volumeLabel.setForeground(Color.WHITE);
        volumeLabel.setVisible(true);
        volumeLabel.setBounds(80, 0, 60, 20);
        
        volumeSlider.add(volumeLabel);

        volumeSlider.addChangeListener(e -> {
            audioPlayer.setVolume(volumeSlider.getValue());
        });
    }

    public JSlider getVolumeSlider() {
        return volumeSlider;
    }
}
