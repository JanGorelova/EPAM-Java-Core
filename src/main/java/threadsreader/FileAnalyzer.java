package threadsreader;

import threadsreader.io.CSVFileReader;
import threadsreader.io.CSVFileWriter;
import threadsreader.model.UserVisit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class FileAnalyzer {
    private static final HashMap<UserVisit, Integer> statistics = new HashMap<>();

    public static void main(final String[] files) throws InterruptedException {
        final List<Thread> threads = new ArrayList<>();

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

    private static synchronized void addVisit(final UserVisit userVisit) {
        if (statistics.containsKey(userVisit)) {
            Integer currentTime = statistics.get(userVisit);
            statistics.put(userVisit, currentTime + userVisit.time);
        } else {
            statistics.put(userVisit, userVisit.time);
        }
    }
}
