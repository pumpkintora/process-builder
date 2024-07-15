class MyRunnable implements Runnable {
    private int count = 0;

    @Override
    synchronized public void run() {
        for (int i = 0; i < 100_000; i++) {
            count++;
        }
        System.out.println(count + Thread.currentThread().getName());
    }
}

public class RaceCondition {
    public static void main(String[] args) {
        Runnable onlyRunnable = new MyRunnable();
        Thread thread1 = new Thread(onlyRunnable, "Thread 1");
        Thread thread2 = new Thread(onlyRunnable, "Thread 2");
        Thread thread3 = new Thread(onlyRunnable, "Thread 3");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
