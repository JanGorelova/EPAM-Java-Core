package threadsreader;

import threadsreader.io.CSVFileGenerator;
import threadsreader.io.CSVFileReader;
import threadsreader.io.CSVFileWriter;
import threadsreader.model.UserVisit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class FileAnalyzer {
    private static final HashMap<UserVisit, Integer> statistics = new HashMap<>();

    public static void main(final String[] files) throws InterruptedException {
        final CSVFileGenerator generator = new CSVFileGenerator("src/main/java/threadsreader/data/input.csv", 5, Arrays.asList("ya.ru", "vk.com", "google.com", "mail.ru", "ok.ru", "aliexpress.com"));
        final List<Thread> threads = new ArrayList<>();

        generator.run();

        for (String file : files) {
            threads.add(new Thread(new CSVFileReader(file, FileAnalyzer::addVisit)));
        }

        for (Thread thread: threads) {
            thread.start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

        new CSVFileWriter("d:\\out.csv", statistics).run();
    }

    /**
     * adds UserVisit to statistics file
     *
     * @param userVisit to be added
     */
    private static synchronized void addVisit(final UserVisit userVisit) {
        if (statistics.containsKey(userVisit)) {
            statistics.put(userVisit, statistics.get(userVisit) + userVisit.time);
        } else {
            statistics.put(userVisit, userVisit.time);
        }
    }
}
