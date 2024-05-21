import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MusicPlayer2 {
    public static List<File> songFiles = Arrays.asList(
            new File("Sounds/Gameplay.wav"),
            new File("Sounds/Tayiaki.wav"),
            new File("Sounds/In Dreamland.wav"),
            new File("Sounds/2 AM.wav"));
    static int currentSong = 0;
    static JProgressBar bar = new JProgressBar();
    static JLabel title = new JLabel();
    static JLabel queue = new JLabel();
    static float currentVolume = 0.0f;
    
    public static void main(String[] args) throws Exception {


        // ------- MAIN GUI ------


        AudioPlayer audioPlayer = new AudioPlayer(songFiles);
        audioPlayer.openSong(songFiles.get(currentSong));
        
        queue.setFont(new Font("Arial", Font.BOLD, 15));
        queue.setForeground(Color.WHITE);
        queue.setVisible(true);
        queue.setText(String.valueOf(currentSong + 1) + "/" + songFiles.size());
        queue.setBounds(350, 40, 50, 50);

        title.setText("Current song: " + songFiles.get(currentSong).getName().replace(".wav", ""));
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setForeground(Color.WHITE);
        title.setVisible(true);
        title.setBounds(80, 40, 200, 50);

        ProgressBar progressBar = new ProgressBar(bar, audioPlayer);
        progressBar.setupProgressBar();

        ControlButtons buttons = new ControlButtons(audioPlayer, title, queue, progressBar);
        VolumeControl volumeControl = new VolumeControl(audioPlayer);

        JFrame frame = new JFrame();
        ImageIcon image = new ImageIcon("Icons/Lightning.png");
        ImageIcon background = new ImageIcon("Icons/VHStape.png");

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(background);
        backgroundLabel.setBounds(0, 0, 450, 300);
        backgroundLabel.setVisible(true);

        frame.setLayout(null);
        frame.setIconImage(image.getImage());
        frame.setTitle("LO-FI RETRO PLAYER");
        frame.setSize(450, 300); 
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(backgroundLabel);
        frame.getContentPane().setBackground(new Color(32, 48, 74));
        frame.setVisible(true);

        frame.add(buttons.playButton);
        frame.add(buttons.stopButton);
        frame.add(buttons.resetButton);
        frame.add(buttons.quitButton);
        frame.add(title);
        frame.add(queue);
        frame.add(buttons.nextButton);
        frame.add(buttons.previousButton);
        frame.add(volumeControl.getVolumeSlider());
        frame.add(bar);
    }
}
