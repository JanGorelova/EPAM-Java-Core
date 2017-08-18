package threadsreader.io;

import threadsreader.model.UserVisit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class CSVFileGenerator implements Runnable {
    private final String filePath;
    private final int usersAmount;
    private final List<String> domains;

    public CSVFileGenerator(final String filePath, final int usersAmount, final List<String> domains) {
        this.filePath = filePath;
        this.usersAmount = usersAmount;
        this.domains = domains;
    }

    @Override
    public final void run() {
        try(final FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < 1000; i++) {
                writer.write(generateVisit() + "\n");
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    private UserVisit generateVisit() {
        return new UserVisit(getRandom(1, usersAmount), domains.get(getRandom(0, domains.size())), getRandom(5, 10));
    }

    private int getRandom(final int min, final int max) {
        return min + (int)(Math.random() * max);
    }
}
