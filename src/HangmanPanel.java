import javax.swing.*;
import java.awt.*;

public class HangmanPanel extends JPanel {
    private static final ImageIcon[] hangmanImages = {
            new ImageIcon("images\\hangman1.png"),
            new ImageIcon("images\\hangman2.png"),
            new ImageIcon("images\\hangman3.png"),
            new ImageIcon("images\\hangman4.png"),
            new ImageIcon("images\\hangman5.png"),
            new ImageIcon("images\\hangman6.png"),
            new ImageIcon("images\\hangman7.png"),
            new ImageIcon("images\\hangman8.png")
    };

    private static int mistakesCount = 0;
    private static String wordWithHiddenLetters;
    private static JLabel jLabel;
    private static boolean gameOver;

    HangmanPanel() {
        gameOver = false;
        this.setBackground(new Color(201, 181, 84));
        this.setOpaque(true);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Main.getWord().length(); i++) {
            sb.append(Main.getWord().charAt(i) == ' ' ? ' ' : '*');
        }
        wordWithHiddenLetters = sb.toString();
        jLabel = new JLabel(wordWithHiddenLetters);
        jLabel.setFont(new Font("Comic Sans", Font.BOLD, 60));
        jLabel.setBackground(new Color(201, 181, 84));
        jLabel.setOpaque(true);
        jLabel.setVerticalTextPosition(JLabel.TOP);
        jLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.add(jLabel);
    }

    public static String getWordWithHiddenLetters() {
        return wordWithHiddenLetters;
    }

    public static void setWordWithHiddenLetters(String wordWithHiddenLetters) {
        HangmanPanel.wordWithHiddenLetters = wordWithHiddenLetters;
        jLabel.setText(wordWithHiddenLetters);
    }


    public static void increaseMistakesCount() {
        mistakesCount++;
        jLabel.setIcon(hangmanImages[mistakesCount - 1]);
    }

    public static int getMistakesCount() {
        return mistakesCount;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        HangmanPanel.gameOver = gameOver;
    }

    public static void victory() {
        jLabel.setIcon(new ImageIcon("images\\victoryDance.gif"));
    }

    public static void reset(){
        gameOver = false;
        mistakesCount = 0;
        jLabel.setIcon(null);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Main.getWord().length(); i++) {
            sb.append(Main.getWord().charAt(i) == ' ' ? ' ' : '*');
        }
        wordWithHiddenLetters = sb.toString();
        jLabel.setText(wordWithHiddenLetters);
    }

    public static void resetSetup(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to start again ?", "Hangman", dialogButton);
        if(dialogResult == 0){
            dialogButton = JOptionPane.YES_NO_OPTION;
            dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to pick a random word?", "Hangman", dialogButton);
            if(dialogResult == 0){
                Main.setWord(Main.getRandomWord());
            }
            else{
                JPasswordField wordField = new JPasswordField();
                int okOrCancel = JOptionPane.showConfirmDialog(null, wordField, "Word", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (okOrCancel == JOptionPane.OK_OPTION) {
                    Main.setWord(String.valueOf(wordField.getPassword()).trim().toUpperCase());
                }
            }
            GuessPanel.reset();
            reset();
            System.err.println("Your word: " + Main.getWord());
        }
    }
}
