package threading;

public final class SausageBying {
    private static int cash = 100;
    private static int price = 1;

    public static void main(String[] args) {
        System.out.println("You have: " + cash + " $");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (cash != 0) {
                    byeSausage(price, 100);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (cash != 0) {
                    byeSausage(price, 100);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (cash != 0) {
                    byeSausage(price, 50);
                }
            }
        }).start();
    }

    private static void byeSausage(final int price, final long sleepTime) {
        if (cash >= price) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cash -= price;
            System.out.println(" Done, tour cash is equal: " + cash + " $");
        } else {
            System.err.println("You don't have enough money!");
        }
    }
}
