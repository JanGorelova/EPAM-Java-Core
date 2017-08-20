package threading;

public final class YieldTest {
    public static void main(String[] args) {
        /**
         * creating new Thread by virtue of implementation of the anonymous class
         * testing the yield test
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100 ; i++) {
                    System.err.println(Thread.currentThread().getName()+ " " + i);
                    Thread.yield();
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
