package stringhomework.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class SameSymbolCounter {
    public static void main(String[] args) {
        SameSymbolCounter counter = new SameSymbolCounter();

        System.out.println(counter.getSymbolValue(counter.getCharsFromText()));
    }

    /**
     * creates line of text read from file
     *
     * @return read chars from text written in file
     */
    private String getCharsFromText() {
        final File file = new File("d:\\projects\\doc.txt");

        final StringBuilder builder = new StringBuilder();

        try (final FileReader fileReader = new FileReader(file)) {
             final BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            do {
                builder.append(line);

                line = reader.readLine();
            } while (line != null);

        } catch (final IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return builder.toString();
    }

    /**
     * creates a new object of class LongestCharacterSubSequence
     * encapsulating the longest sub sequence of the character
     *
     * @param string to be analyzed
     * @return the object of class LongestCharacterSubSequence with longest character sub sequence information
     */
    private LongestCharacterSubSequence getSymbolValue(final String string) {
        Character character = string.charAt(0);
        int maxValue = 1;
        int count = 0;

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i - 1) == string.charAt(i)) {
                count++;

                if (count > maxValue) {
                    character = string.charAt(i);
                    maxValue  = count;
                }
            } else
                count = 1;
        }

        return new LongestCharacterSubSequence(character, maxValue);
    }
}
