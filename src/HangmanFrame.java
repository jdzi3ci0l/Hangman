import javax.swing.*;

public class HangmanFrame extends JFrame {
    HangmanFrame() {
        this.setSize(1100, 800);
        this.setTitle("Hangman");
        this.setIconImage(new ImageIcon("images\\rope.png").getImage());
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HangmanPanel hangmanPanel = new HangmanPanel();
        hangmanPanel.setBounds(0, 0, 700, 800);
        GuessPanel guessPanel = new GuessPanel();
        guessPanel.setBounds(700, 0, 400, 800);

        this.add(hangmanPanel);
        this.add(guessPanel);
        this.setResizable(false);
        this.setVisible(true);
    }
}
