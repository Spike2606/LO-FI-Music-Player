import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;


public class MusicPlayer2 {
    public static List<File> songFiles = Arrays.asList(
            new File("Sounds/A Long Life.wav"),
            new File("Sounds/Adversities.wav"),
            new File("Sounds/Afternoon Tea.wav"),
            new File("Sounds/Air.wav"),
            new File("Sounds/Avatar.wav"),
            new File("Sounds/Bedtime Stories.wav"),
            new File("Sounds/Bleu.wav"),
            new File("Sounds/Breathe It Out.wav"),
            new File("Sounds/Breeze.wav"),
            new File("Sounds/Broken Music Box.wav"),
            new File("Sounds/Cinnamon.wav"),
            new File("Sounds/Cotton.wav"),
            new File("Sounds/Crested.wav"),
            new File("Sounds/Doughnuts.wav"),
            new File("Sounds/Easy Day.wav"),
            new File("Sounds/Friday Vibes.wav"),
            new File("Sounds/Gentle.wav"),
            new File("Sounds/Get Right.wav"),
            new File("Sounds/Grasshopper.wav"),
            new File("Sounds/Happiness.wav"),
            new File("Sounds/Heavy Eyes.wav"),
            new File("Sounds/I-85.wav"),
            new File("Sounds/Indigo.wav"),
            new File("Sounds/Its All Right.wav"),
            new File("Sounds/Laid Out.wav"),
            new File("Sounds/Lullaby.wav"),
            new File("Sounds/Mellow.wav"),
            new File("Sounds/Memories.wav"),
            new File("Sounds/Midnight.wav"),
            new File("Sounds/Moments Notice.wav"),
            new File("Sounds/Montana.wav"),
            new File("Sounds/Moody Blue.wav"),
            new File("Sounds/New York City.wav"),
            new File("Sounds/Nothing Better.wav"),
            new File("Sounds/October.wav"),
            new File("Sounds/Reflections.wav"),
            new File("Sounds/Ringer Off.wav"),
            new File("Sounds/Sleepy Time.wav"),
            new File("Sounds/Snow Goose.wav"),
            new File("Sounds/So Chill.wav"),
            new File("Sounds/So Close.wav"),
            new File("Sounds/Softy.wav"),
            new File("Sounds/Spring.wav"),
            new File("Sounds/Staying In.wav"),
            new File("Sounds/Step.wav"),
            new File("Sounds/Sunlight.wav"),
            new File("Sounds/Sunsets.wav"),
            new File("Sounds/The Big Thrill.wav"),
            new File("Sounds/The Feels.wav"),
            new File("Sounds/The Honey Trap.wav"),
            new File("Sounds/Those Eyes.wav"),
            new File("Sounds/Under The Tree.wav"),
            new File("Sounds/Washed Away.wav"),
            new File("Sounds/White Rabbit.wav"),
            new File("Sounds/Windy City.wav"),
            new File("Sounds/Wolves.wav"),
            new File("Sounds/Wonder.wav"));
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
        queue.setBounds(340, 40, 50, 50);

        title.setText("Current song: " + songFiles.get(currentSong).getName().replace(".wav", ""));
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setForeground(Color.WHITE);
        title.setVisible(true);
        title.setBounds(80, 40, 250, 50);

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