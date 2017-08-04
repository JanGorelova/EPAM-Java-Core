package threading;

public final class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        final Object key = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.err.println(i);
                    if (i==3) {
                        synchronized (key) {
                            key.notifyAll();
                        }
                    }
                }
            }
        });
        System.err.println("Start..");
        thread.start();
        System.err.println("");
        synchronized (key) {
            System.err.println("Wait...");
            key.wait();
        }
        System.out.println("Finish");
    }
}
