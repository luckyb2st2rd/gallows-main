package gallows;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.util.Random;

public class Gallows {
    private static final String PATH = "C:\\projects\\gallows\\src\\dictionary.txt";
    public static final String WORD_SEPARATION = "\\R+";

    public String getWordsToDictionary() throws FileNotFoundException {
        File file = new File(PATH);

        Scanner scanner = new Scanner(file);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        while(scanner.hasNextLine()){
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }

        scanner.close();

        String[] words = sb.toString().split(WORD_SEPARATION);

        String word;
        do {
            word = words[random.nextInt(words.length)].trim();
        } while (word.isEmpty() && words.length > 0);

        return word.toLowerCase();
    }
}
