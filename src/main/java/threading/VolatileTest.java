package threading;

import java.io.IOException;

public final class VolatileTest {
    private static volatile boolean isEnoughCarrot = true;
    /**
     * tests the usage of the volatile key word
     *
     * @param args from command line
     */
    public static void main(String[] args) {
        new Eating().start();
        new StopEating().start();
    }

    /**
     * annotation of the inner class which can be started in the new Thread
     */
    public final static class Eating extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Put the number!");
                int answer = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            isEnoughCarrot = false;
            System.out.println(" The carrot is false");
        }
    }

    /**
     * annotation of the inner class which can be started in the new Thread
     */
    public final static class StopEating extends Thread {
        @Override
        public void run() {
            System.out.println("Lets start");

            while (isEnoughCarrot) {

            }

            System.out.println("We finished");
        }
    }
}

