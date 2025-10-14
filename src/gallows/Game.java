package gallows;

import java.util.Scanner;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.matches;

public class Game {
    private final String word;
    private final char[] mask;
    private final StringBuilder usedSymbol = new StringBuilder();
    private int mistakes = 0;
    private final int maxMistakes;
    private static Scanner scanner;

    public Game(String word, int maxMistakes) {
        while (word == null || word.isEmpty()) {
            System.out.println("Слово не должно быть пустым");
            word = scanner.nextLine();
        }
        this.word = word.toLowerCase();
        this.mask = new char[this.word.length()];

        for (int i = 0; i < mask.length; i++) {
            mask[i] = '*';
        }

        this.maxMistakes = maxMistakes;
    }

    public boolean guessLetter(char symbol) {

        symbol = Character.toLowerCase(symbol);

        if (getUsedSymbol().indexOf(symbol) >= 0) {
            return false;
        }

        if (!Character.toString(symbol).matches("^[а-яА-ЯёЁ]+$")) {
            System.out.println("Введите букву русского алфавита!");
            return false;
        }

        usedSymbol.append(symbol);

        boolean success = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == symbol) {
                mask[i] = symbol;
                success = true;
            }
        }

        if (!success) {
            mistakes++;
        }

        return success;
    }

    public boolean isWon() {
        return word.equals(new String(mask));
    }

    public boolean isLost() {
        return mistakes >= maxMistakes;
    }

    public String getMask() {
        return new String(mask);
    }

    public int getMistakes() {
        return mistakes;
    }

    public int getMaxMixstakes() {
        return maxMistakes;
    }

    public String getWord() {
        return word;
    }

    public String getUsedSymbol() {
        return usedSymbol.toString();

    }
}
