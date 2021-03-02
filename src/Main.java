import javax.swing.*;

public class Main {
    private static final String[] words = {
            "BANANA", "GORILLA", "KING", "QUEEN", "COFFEE", "BOTTLE", "LAMP", "COMPUTER", "MONITOR", "COW", "RAIN",
            "TOY", "BOOK", "STUDENT", "UNIVERSITY", "CHAIR", "TABLE", "DRESS", "BEAR", "CHIMPANZEE", "GIRAFFE", "ELEPHANT",
            "LION", "TRAIN", "PHONE", "LIPSTICK", "BEER", "CARPET", "PILLOW", "BED", "FLOOR", "SHIP", "PIRATE", "TREASURE",
            "DOCTOR", "LAPTOP", "PROGRAMMING", "ARROW", "TERRACOTTA", "TEDDY BEAR", "SEAFOOD", "SAUSAGE", "BACON", "HAMBURGER",
            "BUTTER", "SPAGHETTI", "ICE CREAM", "PANCAKE", "SHRIMP", "HOT DOG", "SALAD", "CHEESE", "PANDA", "CHEETAH", "RABBIT", "TORTOISE",
            "KOALA", "PARROT", "SOLDIER", "SURGEON", "PILOT", "CLOWN", "HOUSEKEEPER", "PAINTER", "MECHANIC", "MAGICIAN", "HARRY POTTER",
            "GARDENER", "FARMER", "ENGINEER", "ARCHITECT", "WAITER", "PARAMEDIC", "DENTIST", "ELECTRICIAN", "FLIGHT ATTENDANT", "FIREFIGHTER",
            "ATHLETE", "BAKER", "TEACHER", "DANCER", "ASTRONAUT", "ELON MUSK", "BARACK OBAMA", "PEACOCK", "GOOSE", "CROW", "HAMMER",
            "SCREWDRIVER", "CORKSCREW", "TOOLBOX", "BOLT", "BUCKET", "SICKLE", "GRASS", "DESERT", "FOREST", "WOOD", "RAINFOREST", "WATERFALL",
            "COAST", "CORAL REEF", "MOUNTAIN", "HILL", "CHEESECAKE", "MICROPHONE", "WEBCAM", "ROUTER", "HEADPHONES", "SPOON", "FORK"
    };
    private static String word;

    public static void main(String[] args) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to pick a random word?", "Hangman", dialogButton);
        if (dialogResult == 0) {
            word = getRandomWord();
        } else {
            JPasswordField wordField = new JPasswordField();
            int okOrCancel = JOptionPane.showConfirmDialog(null, wordField, "Word", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (okOrCancel == JOptionPane.OK_OPTION) {
                word = String.valueOf(wordField.getPassword()).trim().toUpperCase();
            }
        }
        System.err.println("Your word: " + word);
        new HangmanFrame();
    }

    public static String getWord() {
        return word;
    }

    public static String getRandomWord() {
        return words[(int) (Math.random() * words.length)];
    }

    public static void setWord(String word) {
        Main.word = word;
    }
}
