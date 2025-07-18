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
        int numThreads = 12; 
        LoadTask[] threads = new LoadTask[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new LoadTask();
            threads[i].setName("Worker-" + i);
            threads[i].start();
        }

        System.out.println("Threads running for 1 minute...");
        Thread.sleep(10000); 

        for (LoadTask thread : threads) {
            thread.stopRunning();
        }

        for (LoadTask thread : threads) {
            thread.join();
        }

        System.out.println("All threads stopped after 1 minute.");
    }
}

