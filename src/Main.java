import javax.swing.*;

public class Main {
    private static final String[] words = {
            "BANANA", "GORILLA", "KING", "QUEEN", "COFFEE", "BOTTLE", "LAMP", "COMPUTER", "MONITOR", "COW", "RAIN",
            "TOY", "BOOK", "STUDENT", "UNIVERSITY", "CHAIR", "TABLE", "DRESS", "BEAR", "CHIMPANZEE", "GIRAFFE", "ELEPHANT",
            "LION", "TRAIN", "PHONE", "LIPSTICK", "BEER", "CARPET", "PILLOW", "BED", "FLOOR", "SHIP", "PIRATE", "TREASURE"
    };
    private static String word;

    public static void main(String[] args) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to pick a random word?", "Hangman", dialogButton);
        if (dialogResult == 0) {
            word = words[(int) (Math.random() * words.length)];
        } else {
            JPasswordField wordField = new JPasswordField();
            int okOrCancel = JOptionPane.showConfirmDialog(null, wordField, "Word", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (okOrCancel == JOptionPane.OK_OPTION) {
                word = String.valueOf(wordField.getPassword()).trim().toUpperCase();
            }
        }
        System.err.println("Your word: " + word);
        new HangmanFrame();
        //TODO loop application if user wants to start again
    }

    public static String getWord() {
        return word;
    }
}
