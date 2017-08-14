package threadsreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public final class CSVFileReader implements Runnable {
    private final String filePath;
    private final ConcurrentHashMap<UserInformation,Integer> concurrentHashMap;

    public CSVFileReader(final String filePath, final ConcurrentHashMap<UserInformation, Integer> concurrentHashMap) {
        this.filePath = filePath;
        this.concurrentHashMap = concurrentHashMap;
    }

    public final void timeCounter(final ConcurrentHashMap<UserInformation, Integer> concurrentHashMap, final UserInformation userInformation, final Integer time) {
        if (concurrentHashMap.containsKey(userInformation)) {
            Integer currentTime = concurrentHashMap.get(userInformation);
            concurrentHashMap.put(userInformation, currentTime + time);
        } else {
            concurrentHashMap.put(userInformation, time);
        }
    }

    @Override
    public final void run() {
        try (final FileReader fileReader = new FileReader(filePath);
             final BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            String[] info;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                info = line.split(";");
                int id = Integer.parseInt(info[0]);
                String url = info[1];
                int time = Integer.parseInt(info[2]);

                timeCounter(concurrentHashMap,new UserInformation(id,url),time);
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
