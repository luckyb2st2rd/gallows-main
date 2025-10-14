package gallows;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    Game game;

    public static void main(String[] args) throws FileNotFoundException {
        new Menu().run();
    }

    private void run() throws FileNotFoundException {
        startGame();
        takeWord();
        welcomeSpeach();
        playGame();
        gameResult();
    }

    private void startGame() throws FileNotFoundException {
        String word = takeWord();
        this.game = new Game(word, PictureGallows.maxMistakes());
    }

    private String takeWord() throws FileNotFoundException {
        return new Gallows().getWordsToDictionary();
    }

    private void welcomeSpeach() {
        System.out.println("Виселица! Слово: " + game.getMask());
    }

    private void playGame() {
        while (!game.isWon() && !game.isLost()) {
            System.out.println(PictureGallows.picture(game.getMistakes()));
            System.out.println("Использовано: " + game.getUsedSymbol());
            System.out.println("Введите букву: ");
            String letter = scanner.nextLine().trim();
            if (letter.isEmpty()) {
                continue;
            }
            char ch = letter.charAt(0);
            boolean success = game.guessLetter(ch);
            System.out.println((success ? "Есть!" : "Мимо!") + game.getMask());
        }
    }

    private void gameResult() {
        System.out.println(PictureGallows.picture(game.getMistakes()));
        System.out.println(game.isWon()
                ? "Победа! Слово " + game.getWord()
                : "Проигрыш. Слово было: " + game.getWord());
    }

}
