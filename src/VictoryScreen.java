import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.Rectangle;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

/**
 * This is the screen shown if a player has won the game.
 * It shows a score and gives the user an option to play again or exit.
 */
public class VictoryScreen {

    /**
     * JFrame
     */
    private JFrame window;

    /**
     * The game window manager.
     */ 
    private Game game;

    /**
     * The main game, the Game Environment holds all the data as the user goes through the game.
     * It holds the crew members, space out post, space ship, medical supplies etc.
     */ 
    private GameEnvironment environment;
    
    /**
     * Victory Screen constructor
     * @param game The game manager
     */
    public VictoryScreen(Game game) {
        this.game = game;
        this.environment = game.getGameEnvironment();
        initialize();
    }

    /**
     * Closes the home screen
     */
    public void finishedWindow() {
        window.dispose();
    }

    /**
     * Closes victory screen and opens set up screen.
     */
    public void closeWindow() {
        game.closeVictoryScreen(this);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        window = new JFrame();
        window.setBounds(new Rectangle(0, 0, 1000,810));
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        window.getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("Victory");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(12, 12, 974, 81);
        panel.add(lblNewLabel);

        // Produce score
        int totalScore = environment.getScore(false);

        JLabel lblScore = new JLabel("Score: " + totalScore);
        lblScore.setFont(new Font("Dialog", Font.BOLD, 24));
        lblScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblScore.setBounds(12, 150, 974, 81);
        panel.add(lblScore);

        JButton btnNewButton = new JButton("Play Again");
        btnNewButton.setBounds(200, 635, 115, 40);
        panel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                closeWindow();
            }
        });
        
        JButton button = new JButton("Exit");
        button.setBounds(700, 635, 115, 40);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        
        JLabel lblNewLabel_1 = new JLabel("You have found all the parts. Nice job!");
        lblNewLabel_1.setBounds(200, 102, 615, 40);
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
        panel.add(lblNewLabel_1);
        window.setVisible(true);
    }
}
