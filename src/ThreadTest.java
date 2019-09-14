import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest implements Runnable {

	private final ReentrantLock lock = new ReentrantLock();
	private int count = 0;

	public void run() {
		while (true) {
			try {
				getCount();
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

		}
	}

	public int getCount() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
			return count++;
		} finally {
			lock.unlock();
		}
	}

}
