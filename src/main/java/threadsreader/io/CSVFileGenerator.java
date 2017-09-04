package threadsreader.io;

import threadsreader.model.UserVisit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class CSVFileGenerator implements Runnable {
    private final String filePath;
    private final int usersAmount;
    private final List<String> domains;
    /**
     * generates csv file with specified userAmount, domains and filePath
     * implementing Runnable interface
     *
     * @param filePath file to be written
     * @param usersAmount amount of users to be in the file
     * @param domains list of domains to be used in the file
     */
    public CSVFileGenerator(final String filePath, final int usersAmount, final List<String> domains) {
        this.filePath = filePath;
        this.usersAmount = usersAmount;
        this.domains = domains;
    }

    /**
     * writes to file 1000 times new UserVisit objects with random domains, times and users id
     */
    @Override
    public final void run() {
        try(final FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < 20; i++) {
                writer.write(generateVisit() + "\n");
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * generates new UserVisit object with random user number in range from 1 to usersAmount,
     * with random domain from the list of the domains and random time in range from 5 to 10 minutes
     *
     * @return new UserVisit object with random characteristics
     */
    private UserVisit generateVisit() {
        return new UserVisit(getRandom(1, usersAmount), domains.get(getRandom(0, domains.size())), getRandom(5, 10));
    }

    private int getRandom(final int min, final int max) {
        return min + (int)(Math.random() * max);
    }
}
