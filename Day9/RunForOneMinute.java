class LoadTask extends Thread {
    private volatile boolean running = true;

    public void stopRunning() {
        running = false;
    }

    public void run() {
        while (running) {

            double dummy = Math.sin(Math.random());
        }
        System.out.println(Thread.currentThread().getName() + " stopped.");
    }
}

public class RunForOneMinute {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 12; // Matches your 12-core processor
        LoadTask[] threads = new LoadTask[numThreads];

        // Start all threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new LoadTask();
            threads[i].setName("Worker-" + i);
            threads[i].start();
        }

        System.out.println("🕒 Threads running for 1 minute...");
        Thread.sleep(10000); // Wait 1 minute (60000 ms)

        // Stop all threads
        for (LoadTask thread : threads) {
            thread.stopRunning();
        }

        // Join all threads
        for (LoadTask thread : threads) {
            thread.join();
        }

        System.out.println("✅ All threads stopped after 1 minute.");
    }
}

