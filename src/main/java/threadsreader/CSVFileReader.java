package threadsreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public final class CSVFileReader implements Runnable {
    private final String filePath;
    private final Consumer<UserVisit> onUserVisit;

    public CSVFileReader(final String filePath, final Consumer<UserVisit> onUserVisit) {
        this.onUserVisit = onUserVisit;
        this.filePath    = filePath;
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

                onUserVisit.accept(new UserVisit(id, url, time));
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}
