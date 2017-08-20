package task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class OddLettersTest {

    public static void main(String[] args) {
        System.out.println("Put the Word? please!");
        OddLettersTest main = new OddLettersTest();
        System.out.println(main.getOddLetterWord());
    }

    /**
     * creates a new string with letters at the odd places
     *
     * @return string with letters which indexes are the odd numbers
     */
     private String getOddLetterWord() {
        final StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String word = reader.readLine();
            char[] wordArray = word.toCharArray();

            for (int i = 0; i < wordArray.length; i++) {
                if (i % 2 != 0)
                    builder.append(wordArray[i]);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return builder.toString();
    }
}
