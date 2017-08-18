package threadsreader;

import threadsreader.io.CSVFileGenerator;

import java.util.Arrays;

public class FileGenerator {
    public static void main(String[] args) {
        final CSVFileGenerator generator = new CSVFileGenerator("src/main/java/threadsreader/data/input.csv", 5, Arrays.asList("ya.ru", "vk.com", "google.com", "mail.ru", "ok.ru", "aliexpress.com"));
        generator.run();
    }
}
