package task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Test {

    public static void main(String[] args) {
        System.out.println("Put the Word? please!");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder builder =  new StringBuilder();
            String word = reader.readLine();
            char[] wordArr = word.toCharArray();

            for (int i = 0; i < wordArr.length; i++) {
                if (i%2 == 0)
                    builder.append(wordArr[i]);
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
