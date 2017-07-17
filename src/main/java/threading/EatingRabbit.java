package threading;

import java.io.IOException;

public final class EatingRabbit {
    private static volatile boolean isEnoughCarrot = true;

    public static void main(String[] args) {
        new Eating().start();
        new StopEating().start();
    }

    public final static class Eating extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Put the number!");
                    int k = System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                isEnoughCarrot = false;
            System.out.println(" The carrot is false");
            }
        }

        public final static class  StopEating extends Thread {
            @Override
            public void run() {
                System.out.println("Lets start");

                while(isEnoughCarrot) {

                }

                System.out.println("We finished");
            }
        }
    }

