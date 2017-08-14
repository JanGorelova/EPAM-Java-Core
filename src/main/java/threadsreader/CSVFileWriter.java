package threadsreader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public final class CSVFileWriter implements Runnable{
    private final ConcurrentHashMap<UserInformation,Integer> concurrentHashMap;
    private final String filePath;

    public CSVFileWriter(final String filePath, final ConcurrentHashMap<UserInformation, Integer> concurrentHashMap) {
        this.concurrentHashMap = concurrentHashMap;
        this.filePath = filePath;
    }

    @Override
    public final void run() {
        try(final FileWriter writer = new FileWriter(filePath)) {
            for (final UserInformation information : concurrentHashMap.keySet()) {
                writer.write(information.id + ";" + information.url + ";" + concurrentHashMap.get(information) + "\n");
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}

