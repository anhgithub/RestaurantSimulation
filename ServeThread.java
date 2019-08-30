import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ServeThread implements Runnable {
	private BlockingQueue<Food> serverQueue;
	private int numberOfFood;

	public ServeThread(int numberOfFood, BlockingQueue<Food> serverQueue) {
		this.serverQueue = serverQueue;
		this.numberOfFood = numberOfFood;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < numberOfFood; i++) {
				System.out.println("SERVER READY");
				Food food = serverQueue.take();
				// System.out.println("SERVER READY");
				System.out.println("SERVER STARTING: " + food.toString());
				Thread.sleep(food.getServeTime() * 1000);
				System.out.println("SERVER ENDING: " + food.toString());
			}

		} catch (InterruptedException ex) {

		}
	}
}
