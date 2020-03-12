import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrintEvenOddNumbersThread {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        int max = 20;
        threadPool.submit(new PrintEvenOdd(max, true));
        threadPool.submit(new PrintEvenOdd(max, false));

        threadPool.shutdownNow();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static class PrintEvenOdd implements Runnable {
        private static final Object lock = new Object();
        private static int currentNumber = 0;
        private final int max;
        private final int remainder;

        private PrintEvenOdd(int max, boolean printEven) {
            this.max = max;
            if (printEven) {
                this.remainder = 0;
            } else {
                this.remainder = 1;
            }
        }

        @Override
        public void run() {
            while (currentNumber < max) {
                while (currentNumber % 2 != remainder) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            //TODO better logging
                            System.out.println("Got InterruptedException, still continuing : " + e);
                        }
                    }
                }
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " : " + currentNumber);
                    currentNumber++;
                    lock.notify();
                    try {
                        if (currentNumber < max) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        //TODO better logging
                        System.out.println("Got InterruptedException, still continuing : " + e);
                    }
                }
            }
        }
    }
}
