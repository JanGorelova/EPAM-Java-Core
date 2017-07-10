package task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Test {

    public static void main(String[] args) {
        System.out.println("Put the Word? please!");
        Test main = new Test();
        System.out.println(main.getOddLetterWord());
    }

    public final String getOddLetterWord() {
        final StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String word = reader.readLine();
            char[] wordArray = word.toCharArray();

            for (int i = 0; i < wordArray.length; i++) {
                if (i % 2 == 0)
                    builder.append(wordArray[i]);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return builder.toString();
    }
}
