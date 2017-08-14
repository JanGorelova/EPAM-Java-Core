package threadsreader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class FileAnalyzer {
    public static void main(final String[] files) throws InterruptedException {
        final ConcurrentHashMap<UserInformation, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        final List<Thread> threads =  new ArrayList<>();

        for (String file : files) {
            threads.add(new Thread(new CSVFileReader(file,concurrentHashMap)));
        }

        for (Thread thread: threads) {
            thread.start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

        new CSVFileWriter("d:\\out.csv", concurrentHashMap).run();
    }
}
