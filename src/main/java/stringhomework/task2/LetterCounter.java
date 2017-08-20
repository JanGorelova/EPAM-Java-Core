package stringhomework.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public final class LetterCounter {
    public static void main(String[] args) {
        final LetterCounter counter = new LetterCounter();

        System.out.println(counter.getLettersCount(counter.readWord()));
    }

    /**
     * shows the number of the different letters in word
     *
     * @param word to be analyzed
     * @return the number of different letters in specified word
     */
    private int getLettersCount(final String word) {
        final HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < word.length(); i++)
            characters.add(word.charAt(i));

        return characters.size();
    }

    /**
     * prints the word written in console
     *
     * @return the string written in console
     * @throws RuntimeException if user did not enter the word
     */
    private String readWord() {
        System.out.println("Please, put the word");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String word = reader.readLine();
            return word;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("You did not put the word!");
    }
}
