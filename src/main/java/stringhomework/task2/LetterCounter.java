package stringhomework.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class LetterCounter {
    public static void main(String[] args) {
        final LetterCounter counter = new LetterCounter();

        System.out.println(counter.getLetters(counter.readWord()));
    }

    private int getLetters(final String word) {
        int letterCounter = 0;
        final HashMap<Character, Integer> letters = new HashMap<>();

        for (int i = 1; i < word.length(); i++) {
            Character currentChar = word.charAt(i);

            if (letters.containsKey(currentChar)) {
                processWord(currentChar,letters);
            } else {
                letters.put(currentChar,1);
                letterCounter++;
            }
        }

        return letterCounter;
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

    private static void processWord(final Character character, final Map<Character, Integer> letters) {
        letters.put(character, letters.getOrDefault(character, 0) + 1);
    }
}
