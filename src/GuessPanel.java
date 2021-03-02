import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessPanel extends JPanel implements ActionListener {
    private static final JButton[] letters = new JButton[26];

    GuessPanel() {
        int j = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            letters[j] = new JButton(String.valueOf(i));
            letters[j].setFocusable(false);
            letters[j].setFont(new Font("Comic Sans", Font.BOLD, 20));
            letters[j].addActionListener(this);
            this.add(letters[j]);
            j++;
        }
        this.setBackground(new Color(210, 161, 26));
        this.setOpaque(true);
    }

    public static void replaceAsterisks(char c) {
        char[] temp = HangmanPanel.getWordWithHiddenLetters().toCharArray();
        for (int i = 0; i < Main.getWord().length(); i++) {
            if (Main.getWord().charAt(i) == c) {
                temp[i] = c;
            }
        }
        HangmanPanel.setWordWithHiddenLetters(String.valueOf(temp));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!HangmanPanel.isGameOver()) {
            JButton pressedButton = (JButton) e.getSource();
            if (Main.getWord().contains(pressedButton.getText())) {
                replaceAsterisks(pressedButton.getText().charAt(0));
                pressedButton.setBackground(Color.GREEN);
                if (HangmanPanel.getWordWithHiddenLetters().equals(Main.getWord())) {
                    HangmanPanel.setGameOver(true);
                    HangmanPanel.victory();
                }
            } else {
                pressedButton.setBackground(Color.RED);
                HangmanPanel.increaseMistakesCount();
                if (HangmanPanel.getMistakesCount() == 8) {
                    HangmanPanel.setWordWithHiddenLetters(Main.getWord());
                    HangmanPanel.setGameOver(true);
                }
            }
            pressedButton.setEnabled(false);
        }
    }
}

