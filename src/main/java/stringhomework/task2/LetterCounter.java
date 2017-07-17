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

    private int getLettersCount(final String word) {
        final HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < word.length(); i++)
            characters.add(word.charAt(i));

        return characters.size();
    }

    private String readWord() {
        System.out.println("Please, put the word");
        String word = "You did not put the word!";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            word = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return word;
    }
}
