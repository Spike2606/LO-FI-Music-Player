import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlButtons {
    public JButton playButton;
    public JButton stopButton;
    public JButton resetButton;
    public JButton quitButton;
    public JButton nextButton;
    public JButton previousButton;

    public ControlButtons(AudioPlayer audioPlayer, JLabel title, JLabel queue, ProgressBar progressBar) {
        playButton = createButton("Icons/Play.png", 20, 100, new Color(201, 178, 212), e -> {
            audioPlayer.getClip().start();
            Timer timer = new Timer(100, e1 -> progressBar.updateProgressBar());
            timer.start();
        });

        stopButton = createButton("Icons/Stop.png", 120, 100, new Color(201, 178, 212), e -> {
            audioPlayer.getClip().stop();
            progressBar.resetProgressBar();
        });

        resetButton = createButton("Icons/Rep.png", 220, 100, new Color(201, 178, 212), e -> audioPlayer.getClip().setMicrosecondPosition(0));

        quitButton = createButton("Icons/Quit.png", 320, 100, new Color(201, 178, 212), e -> System.exit(0));

        nextButton = createButton2("Icons/Next.png", 330, 200, new Color(201, 178, 212), e -> {
            int currentSong = MusicPlayer2.currentSong;
            if (currentSong < MusicPlayer2.songFiles.size() - 1) {
                MusicPlayer2.currentSong++;
            } else {
                MusicPlayer2.currentSong = 0;
            }
            audioPlayer.openSong(MusicPlayer2.songFiles.get(MusicPlayer2.currentSong));
            updateTitleAndQueue(title, queue);
            audioPlayer.getClip().start();
            Timer timer = new Timer(100, e1 -> progressBar.updateProgressBar());
            timer.start();
        });

        

        previousButton = createButton2("Icons/Prev.png", 230, 200, new Color(201, 178, 212), e -> {
            int currentSong = MusicPlayer2.currentSong;
            if (currentSong > 0) {
                MusicPlayer2.currentSong--;
            } else {
                MusicPlayer2.currentSong = MusicPlayer2.songFiles.size() - 1;
            }
            audioPlayer.openSong(MusicPlayer2.songFiles.get(MusicPlayer2.currentSong));
            updateTitleAndQueue(title, queue);
            audioPlayer.getClip().start();
            Timer timer = new Timer(100, e1 -> progressBar.updateProgressBar());
            timer.start();
        });
        
    }


    

    private JButton createButton(String iconPath, int x, int y, Color color, ActionListener actionListener) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setIcon(new ImageIcon(iconPath));
        button.setBounds(x, y, 80, 50);
        button.addActionListener(actionListener);
        button.setVisible(true);

        return button;
    }

    private JButton createButton2(String iconPath, int x, int y, Color color, ActionListener actionListener) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setIcon(new ImageIcon(iconPath));
        button.setBounds(x, y, 90, 50);
        button.addActionListener(actionListener);
        button.setVisible(true);

        return button;
    }

    private void updateTitleAndQueue(JLabel title, JLabel queue) {
        title.setText("Current song: " + MusicPlayer2.songFiles.get(MusicPlayer2.currentSong).getName().replace(".wav", ""));
        queue.setText(String.valueOf(MusicPlayer2.currentSong + 1) + "/" + MusicPlayer2.songFiles.size());
    }

    
}
