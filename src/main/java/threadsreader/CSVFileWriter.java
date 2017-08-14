package threadsreader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public final class CSVFileWriter implements Runnable {
    private final Map<UserVisit,Integer> concurrentHashMap;
    private final String filePath;

    public CSVFileWriter(final String filePath, final Map<UserVisit, Integer> concurrentHashMap) {
        this.concurrentHashMap = concurrentHashMap;
        this.filePath = filePath;
    }

    @Override
    public final void run() {
        try(final FileWriter writer = new FileWriter(filePath)) {
            for (final UserVisit information : concurrentHashMap.keySet()) {
                writer.write(information.id + ";" + information.url + ";" + concurrentHashMap.get(information) + "\n");
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}

