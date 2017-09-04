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
    private static final List<String> filePaths = new ArrayList<>();
    private static final List<CSVFileGenerator> generators = new ArrayList<>();

    public static void main(final String[] args) throws InterruptedException {
        final List<Thread> threads = new ArrayList<>();

        fillTheFilePaths();

        for (final String filepath : filePaths) {
            generators.add(new CSVFileGenerator(filepath, 6,Arrays.asList("ya.ru", "vk.com", "google.com", "mail.ru", "ok.ru", "aliexpress.com")));

        }

        for (final CSVFileGenerator currentGenerator : generators) {
            new Thread(currentGenerator).start();
        }


        for (String file : filePaths) {
            threads.add(new Thread(new CSVFileReader(file, FileAnalyzer::addVisit)));
        }

        for (Thread thread: threads) {
            thread.start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

        new CSVFileWriter("src/main/java/threadsreader/data/outputInfo.csv", statistics).run();
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

    /**
     * fill the filepath of the 10 used files
     */
    private static void fillTheFilePaths() {
        filePaths.add("src/main/java/threadsreader/data/file1.csv");
        filePaths.add("src/main/java/threadsreader/data/file2.csv");
        filePaths.add("src/main/java/threadsreader/data/file3.csv");
        filePaths.add("src/main/java/threadsreader/data/file4.csv");
        filePaths.add("src/main/java/threadsreader/data/file5.csv");
        filePaths.add("src/main/java/threadsreader/data/file6.csv");
        filePaths.add("src/main/java/threadsreader/data/file7.csv");
        filePaths.add("src/main/java/threadsreader/data/file8.csv");
        filePaths.add("src/main/java/threadsreader/data/file9.csv");
        filePaths.add("src/main/java/threadsreader/data/file10.csv");
    }
}
